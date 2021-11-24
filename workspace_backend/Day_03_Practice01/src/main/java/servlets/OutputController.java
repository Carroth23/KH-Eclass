package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dto.EmployeeDTO;


@WebServlet("/OutputController")
public class OutputController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		
		try {
			List<EmployeeDTO> list = dao.select();
			request.setAttribute("list", list);
			request.getRequestDispatcher("outputView.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
