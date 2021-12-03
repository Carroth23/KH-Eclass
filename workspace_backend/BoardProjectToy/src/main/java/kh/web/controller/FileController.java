package kh.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.web.dao.FileDAO;
import kh.web.dto.FileDTO;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 얘는 걍 냅둘것
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);
		FileDAO dao = FileDAO.getInstance();
		
		try {
			if (cmd.equals("/fileList.file")) {
				System.out.println("여기옴");
				List<FileDTO> list = dao.selectAll();
				System.out.println(list);
				Gson g = new Gson();
				String result = g.toJson(list);
				response.setContentType("text/html;charset=utf8;");
				response.getWriter().append(result);
				System.out.println("fileList 실행됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
