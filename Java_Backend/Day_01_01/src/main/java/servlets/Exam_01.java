package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam_01") // 어노테이션 이 주소를 가지고있으면 여기로 보내라.
public class Exam_01 extends HttpServlet {
	// private static final long serialVersionUID = 1L; 지워도 되는아이
	// public Exam_01() { 기본생성자는 없으면 있는거랑 같은것이니 지워도 됨.
	// super();
	//
	// }
	
	// Servlet의 두가지 역할
	// 1. 클라이언트의 복잡한 요청을 처리한다.
	// 2. 처리된 내용을 바탕으로 응답을 작성하여 반환한다.

	
	// protected는 접근제한자인데 의미가 좀 변질되었다.
	// 얘는 오버라이드해서 쓰는게 좋을걸? 이라는 의미로 좀 변질됨
	
	// Request는 클라이언트가 보내는 정보들이 채워져있는것. Response는 서블릿이 작업을 처리하고 다시 채워서 보낼것.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 작업의 처리...
		String currentTime = new Date().toString();
		
		
		// response 를 작성하는 작업
		PrintWriter pw = response.getWriter();
		pw.append(currentTime);
	}

	// Post로 받아고 get으로 넘겨버림
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
