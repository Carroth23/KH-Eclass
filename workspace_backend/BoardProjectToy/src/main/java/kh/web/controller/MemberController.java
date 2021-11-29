package kh.web.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.web.dao.MemberDAO;
import kh.web.dto.MemberDTO;
import kh.web.utils.EncryptUtils;

@WebServlet("*.mem")
public class MemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 크롬은 ms949 인코딩으로 한다 아마 그래서 한글이 깨짐
		// 그래서 맨 처음 데이터가 올때 utf-8인코딩처리를 먼저 함
		// 얘는 post방식에서만 적용됨. get방식에서는 안됨ㅎㅎ
		// 그래서 server.xml에 URIEncoding="utf-8" 이거 추가
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		System.out.println("요청 URI : " + uri);
		String ctx = request.getContextPath();
		System.out.println("요청 CTX : " + ctx);
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);

		// DAO칸
		MemberDAO dao = MemberDAO.getInstance();
		try {
			if (cmd.equals("/signup.mem")) { // 회원가입 폼으로 이동

				response.sendRedirect("member/signup.jsp");

			} else if (cmd.equals("/idCheck.mem")) { // 아이디 중복 체크 기능

				String id = request.getParameter("id");
				System.out.println("서버로 전달된 id : " + id);
				boolean result = dao.isIdExist(id);
				System.out.println(result);

				request.setAttribute("result", result);
				request.getRequestDispatcher("/member/idCheckView.jsp").forward(request, response);

			} else if (cmd.equals("/sign.mem")) { // 회원가입 눌렀을때오는곳

				// 크롬은 ms949 인코딩으로 한다 아마 그래서 한글이 깨짐
				String id = request.getParameter("id");
				String pw = EncryptUtils.getSHA512(request.getParameter("pw"));
				String name = request.getParameter("name");
				String phone1 = request.getParameter("phone1");
				String phone2 = request.getParameter("phone2");
				String phone3 = request.getParameter("phone3");
				String phone = phone1 + phone2 + phone3;
				String email = request.getParameter("email");
				String zipcode = request.getParameter("postcode");
				String address1 = request.getParameter("roadAddress");
				String address2 = request.getParameter("jibunAddress");

				System.out.println(id);
				int sign = dao.insert(new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, null));
				if (sign > 0) {
					System.out.println("회원가입 성공");
					response.sendRedirect("index.jsp");
				} else {
					System.out.println("가입 실패");
				}
			} else if (cmd.equals("/loginCheck.mem")) {
				// 로그인을 처리하는 방식 대표적인 두가지
				// 1. 쿠키파일 사용방식(얘는 클래식한 방법) 대신 쿠키파일방법은 쿠키파일에 너무 중요한 정보들이 들어감.
				// - 쿠키파일은 탈취당할 수도 있음 "파일"이기 때문.
				// - 쿠키파일만 있으면 로그인이 된것과 마찬가지임. 그 안에는 중요한 정보도 많이들어있다. (겁나위험)
				// - 얘는 장바구니나 뭐 그런거에씀 (노출되도 상관없는 기능들쓸때)
				// 2. 세션을 이용한 로그인 - 서버에 정보를 저장하고(이 저장소를 세션이라 부름)
				// - 그걸 열수 있는 키를 생성하고 클라이언트에게 키값를 줌.(얘가 보안성 더 좋음)
				// - 그리고 키값과 정보들을 램(메모리)에 담는다. 이러면 훔치기 훨씬 힘들어진다. 키값이 일치하면 이제 문이 열림
				
				// 리퀘스트에 안넣는 이유는 세션과의 라이프사이클 차이때문
				// 리퀘스트에 넣으면 포워드되는 영역까지만 생존. 페이지가 바뀌면 아예 정보가 사라짐(원래 없던것이됨)
				// 세션객체는 tomcat이 가동되는 순간부터 생성되어, tomcat이 종료되는 순간까지 생존한다.
				String id = request.getParameter("id");
				String pw = EncryptUtils.getSHA512(request.getParameter("pw"));
				boolean loginCheck = dao.loginCheck2(id, pw);
				if(loginCheck) {
					HttpSession session = request.getSession(); // 이게 세션 꺼낸거(금고)
					
					MemberDTO dto = dao.selectAll(id);
					
					session.setAttribute("loginID", dto.getId()); // 나중엔 정보들 여기에 다 담음 키값과 밸류이런식으로 담는듯(loginId라는 키값에 전달받은 id를 저장)
					session.setAttribute("loginPw", dto.getPw());
					session.setAttribute("loginName", dto.getName());
					session.setAttribute("loginPhone", dto.getPhone());
					session.setAttribute("loginEmail", dto.getEmail());
					session.setAttribute("loginZipcode", dto.getZipcode());
					session.setAttribute("loginAddress1", dto.getAddress1());
					session.setAttribute("loginAddress2", dto.getAddress2());
					session.setAttribute("loginSignup_Date", dto.getSignup_date());
					
					// 아무것도 안해도 클라이언트한테 세션 키값이 전달됨.
					System.out.println("로그인 성공");
					response.sendRedirect("/index.jsp"); // 다시 인덱스로 가도 서버쪽 세션에 아이디와 키값이 저장되어 있다.
					// 포워드로 안보내는것은 어차피 세션에 정보가 있으니까
					// 클라이언트는 접속하자마자 세션키값을 하나 받는다. 근데 그 키가 맞는곳엔 비어있겠지..
					// 세션은 톰캣 켜자마자 만들어짐.
					// 키값은 브라우저마다 만들어짐 크롬에서 로그인하고 엣지로 다시 들어가면 로그인 안되있는것처럼
					// 크롬 다끄면 세션 사라짐(아마?)
				} else {
					System.out.println("로그인 실패");
					response.sendRedirect("/index.jsp");
				}

			} else if (cmd.equals("/logout.mem")) {
				
				request.getSession().invalidate(); // 접속한 사용자의 키값으로 저장되어 있는 모든 내용을 전부 삭제하라.
//				request.getSession().removeAttribute("loginID"); // 로그인 정보만 삭제? loginID 키값 속성을 지운거
				response.sendRedirect("/index.jsp");
				
			} else if (cmd.equals("/leave.mem")) {
				
				String id = (String) request.getSession().getAttribute("loginID");
				int result = dao.delete(id); // 세션에 담으면 안됨. 세션이 끝나기전까지 메모리 상주
//				request.setAttribute("result", request);
				request.getSession().invalidate(); // 탈퇴를 하면 세션에서도 삭제시켜야 하므로.
//				request.getRequestDispatcher("/index.jsp").forward(request, response); 얜 필요없긴함 탈퇴에 실패할리가 ㅎㅎ
				response.sendRedirect("/index.jsp");
				
			} else if (cmd.equals("/mypage.mem")) {
				
				String id = (String) request.getSession().getAttribute("loginID");
				MemberDTO dto = dao.selectAll(id);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/member/myPage.jsp").forward(request, response);
				
				
				request.setAttribute("id", dto.getId());
				
				
			} else if (cmd.equals("/modify.mem")) {
				String id = (String) request.getSession().getAttribute("loginID");
				String pw = EncryptUtils.getSHA512(request.getParameter("pw"));
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("postcode");
				String address1 = request.getParameter("roadAddress");
				String address2 = request.getParameter("jibunAddress");
				Date signup_date = (Date)request.getSession().getAttribute("loginSignup_Date");
				System.out.println(email);
				System.out.println(name);
				MemberDTO dto = new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, signup_date);
				System.out.println(dto.getId());
				int result = dao.modify(dto);
				if(result > 0) {
					HttpSession session = request.getSession();
					System.out.println("변경 완료"); // 변경 완료 후 세션에 다시 담기
					session.setAttribute("loginID", dto.getId());
					session.setAttribute("loginPw", dto.getPw());
					session.setAttribute("loginName", dto.getName());
					session.setAttribute("loginPhone", dto.getPhone());
					session.setAttribute("loginEmail", dto.getEmail());
					session.setAttribute("loginZipcode", dto.getZipcode());
					session.setAttribute("loginAddress1", dto.getAddress1());
					session.setAttribute("loginAddress2", dto.getAddress2());
					session.setAttribute("loginSignup_Date", dto.getSignup_date());
					System.out.println(request.getSession().getAttribute("loginEmail"));
					response.sendRedirect("/index.jsp");
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("member/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
