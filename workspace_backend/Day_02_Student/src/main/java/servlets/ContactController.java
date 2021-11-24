package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.StudentDTO;

@WebServlet("*.con")
public class ContactController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = uri.substring(ctxPath.length());

		StudentDAO dao = StudentDAO.getInstance();
		try {
			if (cmd.equals("/output.con")) {

				List<StudentDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);

			} else if (cmd.equals("/input.con")) {
				String name = request.getParameter("name");
				int kor = Integer.parseInt(request.getParameter("kor"));
				int eng = Integer.parseInt(request.getParameter("eng"));

				int result = dao.insert(name, kor, eng);

				request.setAttribute("result", result); // result라는 키값으로 result를 가져가라
				request.getRequestDispatcher("inputView.jsp").forward(request, response);

			} else if (cmd.equals("/delete.con")) {
				int delSeq = Integer.parseInt(request.getParameter("delID"));

				dao.delete(delSeq);
				response.sendRedirect("output.con");

			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
