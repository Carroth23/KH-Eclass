package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
	// Controller (Model, View, Controller 이셋 을 합쳐 디자인패턴 MVC라고 부름)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactDAO dao = ContactDAO.getInstance();

		String name = request.getParameter("name");
		String contact = request.getParameter("contact");

		try {
			int result = dao.insert(name, contact); // 성공이거나 실패안 결과값(true,false)을 jsp페이지로 보내야됨.
			
			request.setAttribute("result", result);
//			request.getRequestDispatcher("inputView.jsp").forward(request, response); // 이게 보내는거
			response.sendRedirect("inputView.jsp");
			// forward로 보내면 클라이언트의 주소창이 inputView로 바뀌지 않음. 서버가 그 페이지를 보여주는것이니까.
			// forward로 보낸다면 클라이언트가 준 가방을 사용할 수 있다.(mvc2가 forward에 의해 만들어짐 중요함.)
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
