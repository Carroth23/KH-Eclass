package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_servlet")
public class _servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");

//		System.out.println(name + " 님의 연락처 : " + contact);
//		response.getWriter().append("Input Succes");

		// 넘어온 데이터를 데이터베이스에 저장
		// 다이나믹 웹프로젝트에선 라이브러리 추가시에 src->main->webapp->WEB-INF->lib폴더에 jar파일을 넣는다.
		// 빌드패스로 넣는거 아님 ㅎㅎ
//		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
//		String username = "kh";
//		String password = "kh";
//		String sql = "insert into contact values(contact_seq.nextval,?,?)";
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//			response.sendRedirect("error.html");
//		}
//		try (Connection con = DriverManager.getConnection(url, username, password);
//				PreparedStatement pstat = con.prepareStatement(sql);) {
//			pstat.setString(1, name);
//			pstat.setString(2, contact);
//			int result = pstat.executeUpdate();
//			response.sendRedirect("index.html"); // 작업을 마치고 방향을 바꿔주는것. 그냥 볼일끝났으니 저쪽으로 가라
//		} catch (Exception e) {
//			e.printStackTrace();
//			response.sendRedirect("error.html");
//		}

//		String name = request.getParameter("name");
//	      String contact = request.getParameter("contact");
//	      
//	      PrintWriter pw = response.getWriter();
//	      pw.append(name);
//	      pw.append(contact);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
