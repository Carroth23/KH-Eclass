package kh.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.web.dao.NaverDAO;

@WebServlet("*.trs")
public class TranslateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getServletPath();
		if (cmd.equals("/toPage.trs")) {
			response.sendRedirect("/translate/translator.jsp");
		} else if (cmd.equals("/translate.trs")) {
			String src = request.getParameter("src");
			String translate = NaverDAO.translate(src);
			response.getWriter().append(translate);
			
//			System.out.println(translate); 뻘짓
//			
//			int start = translate.indexOf("\"translatedText\":");
//			int last = translate.lastIndexOf(",\"engineType\"");
//			String cutMsg = translate.substring(start, last);
//			System.out.println(start);
//			System.out.println(last);
//			System.out.println(cutMsg);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
