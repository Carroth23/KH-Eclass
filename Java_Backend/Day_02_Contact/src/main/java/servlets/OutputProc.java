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


@WebServlet("/OutputProc")
public class OutputProc extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String[] arr = new String[] {"Apple","Orange"};
//		ContactDTO dto = new ContactDTO(100,"ABC","DEF");
//		
//		List<ContactDTO> list = new ArrayList<>();
//		
//		list.add(new ContactDTO(2200,"AAC","CCC"));
//		list.add(new ContactDTO(2300,"BBB","BBB"));
//		list.add(new ContactDTO(2400,"CCC","AAA"));
//		
//		request.setAttribute("simple1", 12);
//		request.setAttribute("simple2", "Hello");
//		request.setAttribute("array", arr);
//		request.setAttribute("contact", dto);
//		
//		request.setAttribute("list", list);
		
		ContactDAO dao = ContactDAO.getInstance();
		try {
			List<ContactDTO> list = dao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("outputView.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		request.getRequestDispatcher("outputView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
