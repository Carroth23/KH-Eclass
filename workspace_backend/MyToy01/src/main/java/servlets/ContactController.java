package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import dto.ContactDTO;


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
			if(cmd.equals("/output.con")) {
				List<ContactDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);
			} else if (cmd.equals("/delete.con")) {
				int delID = Integer.parseInt(request.getParameter("delID"));
				dao.delete(delID);
				response.sendRedirect("output.con");
			} else if (cmd.equals("/insert.con")) {
				String name = request.getParameter("name");
				String contact = request.getParameter("contact");
				dao.insert(name, contact);
				response.sendRedirect("output.con");
			} else if (cmd.equals("/modify.con")) {
				String contact = request.getParameter("contact");
				String name = request.getParameter("name");
				int seq = Integer.parseInt(request.getParameter("seq"));
				dao.modify(contact, name, seq);
				response.sendRedirect("output.con");
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
