package kh.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.web.dao.MemberDAO;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println("요청 URI : " + uri);
		String ctx = request.getContextPath();
		System.out.println("요청 CTX : " + ctx);
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);
		
//		MemberDAO dao = MemberDAO.getInstance(); 필요하면 쓸거
		
		try {
			if (cmd.equals("/boardWrite.board")) {
				
				response.sendRedirect("/board/boardWrite.jsp");
				
				
				
			} else if (cmd.equals("?")) {
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/member/error.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
