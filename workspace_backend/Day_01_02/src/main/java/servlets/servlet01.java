package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet01")
public class servlet01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = request.getParameter("message"); // url로 넘어온 메세지를 리퀘스트 파라미터로 꺼내옴. 이때 name="message"값이 이름표이다

		PrintWriter pw = response.getWriter();
		pw.append("<html>");
		pw.append("<html>");
		pw.append("<font color=pink size=20>");
		pw.append(name + "'s message : " + message);
		pw.append("</font>");
		pw.append("</body>");
		pw.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
