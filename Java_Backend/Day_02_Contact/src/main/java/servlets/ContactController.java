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

@WebServlet("*.con") // *은 모든것 asdsad아무거나 오다가 .con 이 붙으면 다 여기로 보내라 근데 무슨용무로 여기온걸까?
public class ContactController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println("사용자가 요청한 주소" + uri);
//		/Day_02_Contact/ouput.con중 앞의 /Day_02_Contact 를 ContextPath라고 함

		String ctxPath = request.getContextPath(); // ContextPath만 뽑아내기
		System.out.println("프로젝트 명 : " + ctxPath);

		String cmd = uri.substring(ctxPath.length()); // ContextPath의 길이만큼 잘라버리고 그 뒤부터 선택
		System.out.println("사용자가 요청한 기능 : " + cmd);

		ContactDAO dao = ContactDAO.getInstance(); // 그래서 꺼냄
		try { // 얘도 한방에 처리
			if (cmd.equals("/output.con")) {

//			ContactDAO dao = ContactDAO.getInstance(); // 지역변수로 있을 필요가 없다
				List<ContactDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);

			} else if (cmd.equals("/input.con")) {

				String name = request.getParameter("name");
				String contact = request.getParameter("contact");
				int result = dao.insert(name, contact);
				response.sendRedirect("index.html");

			} else if (cmd.equals("/modify.con")) {

				int seq = Integer.parseInt(request.getParameter("seq"));
				String name = request.getParameter("name");
				String contact = request.getParameter("contact");
				int result = dao.modify(new ContactDTO(seq, name, contact));
				response.sendRedirect("output.con");

			} else if (cmd.equals("/delete.con")) {

				int delID = Integer.parseInt(request.getParameter("delID"));
				int result = dao.delete(delID);
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
