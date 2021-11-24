package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);
		
		// DAO칸
		try {
			if (cmd.equals("/signup.mem")) {
				response.sendRedirect("member/signup.jsp");
			} else if (cmd.equals("/idCheck.mem")) {
				String id = request.getParameter("id");
				System.out.println("서버로 전달된 id : " + id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
