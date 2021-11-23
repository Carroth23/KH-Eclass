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
		StudentDAO dao = StudentDAO.getInstance();
		PrintWriter pw = response.getWriter();
		
		try {
			List<StudentDTO> list = dao.selectAll();
			
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<table border=1 align=center>");
			pw.append("<tr>");
			pw.append("<td>Number");
			pw.append("<td>Name");
			pw.append("<td>KOR");
			pw.append("<td>ENG");
			pw.append("<td>SUM");
			pw.append("<td>AVG");
			pw.append("</tr>");
			for(StudentDTO dto : list) {
				pw.append("<tr>");
				pw.append("<td>" + dto.getSeq());
				pw.append("<td>" + dto.getName());
				pw.append("<td>" + dto.getKor());
				pw.append("<td>" + dto.getEng());
				pw.append("<td>" + (dto.getEng() + dto.getKor()));
				pw.append("<td>" + (dto.getEng() + dto.getKor()) / 2);
				pw.append("</tr>");
			}
			pw.append("<tr>");
			pw.append("<td colspan=6>");
			pw.append("<form action='DeleteProc' method=get>");
			pw.append("<input type=text name=delID placeholder='delID Input'>");
			pw.append("<button>Delete</button>");
			pw.append("</form>");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<th colspan=6 align=center><a href='index.html'>back</a>");
			pw.append("</tr>");
			pw.append("</table>");
			pw.append("</body>");
			pw.append("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
