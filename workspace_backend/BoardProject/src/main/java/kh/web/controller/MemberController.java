package kh.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.web.dao.MemberDAO;
import kh.web.dto.MemberDTO;
import kh.web.utils.EncryptUtils;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				System.out.println(address1);
				System.out.println(address2);
				
				System.out.println(id);
//				int sign = dao.insert(new MemberDTO(id,pw,name,phone,email,zipcode,address1,address2));
//				if (sign > 0) {
//					System.out.println("회원가입 성공");
//				} else {
//					System.out.println("가입 실패");
//				}
			} else if (cmd.equals("/loginCheck.mem")) {
				
				try {
					String id = request.getParameter("id");
					String pw = request.getParameter("pw");
					MemberDTO dto = dao.loginCheck(id, pw);
					System.out.println(dto.getName());
					System.out.println(dto.getPhone());
					System.out.println(dto.getEmail());
					request.setAttribute("dto", dto);
					request.getRequestDispatcher("/member/loginSuccess.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("member/loginFail.jsp");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("member/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
