package h.toy.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import h.toy.dao.MemberDAO;
import h.toy.dto.MemberDTO;
import h.toy.utils.EncryptUtils;

@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getServletPath();
		System.out.println(request.getRequestURI());
		System.out.println(cmd);
		HttpSession session = request.getSession(); // 세션 꺼내고
		MemberDAO dao = MemberDAO.getInstance();
		try {
			if (cmd.equals("/beforeSignup.mem")) { // index에서 회원가입 클릭시 오는곳
				response.sendRedirect("/member/signup.jsp");
			} else if (cmd.equals("/idCheck.mem")) { // 이거 해결해야됨 아이디중복확인누르면 얼럿으로 띄울거
				
				String idval = request.getParameter("idval");
				boolean idChecked = dao.idCheck(idval);
				System.out.println(idChecked);
				request.setAttribute("idChecked", idChecked);
				request.getRequestDispatcher("/member/signup.jsp").forward(request, response);
				
			} else if (cmd.equals("/signupComplete.mem")) {
				String id = request.getParameter("id");
				String pw = EncryptUtils.getSHA512(request.getParameter("pw"));
				String name = request.getParameter("name");
				String phone1 = request.getParameter("phone1");
				String phone2 = request.getParameter("phone2");
				String phone3 = request.getParameter("phone3");
				String phone = phone1 + phone2 + phone3;
				String email = request.getParameter("email");
				String zipcode = request.getParameter("zipcode");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				int result = dao.signup(new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, null));
				if(result > 0) {
					System.out.println("가입 완료");
					response.sendRedirect("/index.jsp");
				} else {
					response.sendRedirect("/error.jsp");
				}
			} else if (cmd.equals("/loginCheck.mem")) { // 로그인
				String id = request.getParameter("id");
				String pw = EncryptUtils.getSHA512(request.getParameter("pw"));
				MemberDTO dto = dao.loginCheck(id, pw);
				if(dto != null) {
					session.setAttribute("loginId", id);
					session.setAttribute("loginPw", pw);
					session.setAttribute("loginName", dto.getName());
					session.setAttribute("loginPhone", dto.getPhone());
					session.setAttribute("loginEmail", dto.getEmail());
					session.setAttribute("loginZipcode", dto.getZipcode());
					session.setAttribute("loginAddress1", dto.getAddress1());
					session.setAttribute("loginAddress2", dto.getAddress2());
					session.setAttribute("loginSignup_date", dto.getSignup_date());
					response.sendRedirect("/index.jsp");
				} else {
					response.sendRedirect("/error.jsp");
				}
			} else if (cmd.equals("/logout.mem")) { // 로그아웃
				session.invalidate(); // 세션삭제
				response.sendRedirect("/index.jsp");
			} else if (cmd.equals("/leave.mem")) {
				
				
				
			} else if (cmd.equals("")) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
