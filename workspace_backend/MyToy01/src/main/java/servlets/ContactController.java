package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;


@WebServlet("*.con")
public class ContactController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("요청URI : " + uri);
		String ctx = request.getContextPath();
		System.out.println("요청CTX : " + ctx);
		String cmd = uri.substring(ctx.length());
		System.out.println("요청CMD : " + cmd);
		
		ContactDAO dao = ContactDAO.getInstance();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
