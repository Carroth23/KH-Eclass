package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import dto.ContactDTO;


@WebServlet("/ModifyProc")
public class ModifyProc extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDAO dao = ContactDAO.getInstance();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		
		try {
			int result = dao.modify(new ContactDTO(seq,name,contact));
			response.sendRedirect("OutputProc");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
