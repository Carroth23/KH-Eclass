package toy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toy.board.dao.MemDAO;
import toy.board.dto.MemDTO;

@WebServlet("*.mem")
public class MemController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getServletPath();
		HttpSession session = request.getSession();
		MemDAO dao = MemDAO.getInstance();
		
		try {
			if(cmd.equals("/signup.mem")) {
				response.sendRedirect("/member/signup.jsp");
			} else if (cmd.equals("/signupC.mem")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				int suc = dao.memInsert(new MemDTO(0, id, pw, name, null));
				if(suc == 1) {
					System.out.println(id + " 님 회원가입.");
				}
				response.sendRedirect("/index.jsp");
			} else if (cmd.equals("/login.mem")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				MemDTO dto = dao.memLogin(id, pw);
				session.setAttribute("loginId", dto.getId());
				session.setAttribute("loginName", dto.getName());
				session.setAttribute("signupDate", dto.getSignupDate());
				response.sendRedirect("/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
