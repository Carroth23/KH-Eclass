package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.StudentDTO;

@WebServlet("/OutputProc")
public class OutputProc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] arr = new String[] {"Apple","Mango","Orange"};
		StudentDTO dto = new StudentDTO(100,"Hong",70,80);
		
		
		
		request.setAttribute("simple1", 10); // request에 값을 넣은것.
		request.setAttribute("simple2", "Hello");
		request.setAttribute("array", arr);
		request.setAttribute("student", dto);
		
		request.getRequestDispatcher("outputView.jsp").forward(request, response);
		
		
//		StudentDAO dao = StudentDAO.getInstance();
//		PrintWriter pw = response.getWriter();
//		
//		try {
//			List<StudentDTO> list = dao.selectAll();
//			
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("outputView.jsp").forward(request, response);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.sendRedirect("error.html");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
