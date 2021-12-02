package kh.web.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.web.dto.ContactDTO;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getServletPath();
		System.out.println(cmd);
		Gson g = new Gson(); // 라이브러리
		
		if(cmd.equals("/exam01.ajax")) {
			System.out.println("exam01 : 비동기 요청 확인");
			System.out.println("뭐임");
		} else if (cmd.equals("/exam02.ajax")) {
			String key1 = request.getParameter("appleKey");
			String key2 = request.getParameter("orangeKey");
			System.out.println(key1 + " : " + key2);
		} else if (cmd.equals("/exam03.ajax")) {
			System.out.println("exam03: 비동기 요청 확인");
			response.getWriter().append("Ajax Response!");
		} else if (cmd.equals("/exam04.ajax")) {
			System.out.println("배열 데이터 요청 확인");
			String[] arr = new String[] {"Apple", "Orange", "Mango"};
			
			String result = g.toJson(arr); // JS식 배열같은 문자열로 만들어줌
			response.getWriter().append(result);
			
		} else if (cmd.equals("/exam05.ajax")) {
			System.out.println("객체 데이터 요청 확인");
			ContactDTO dto = new ContactDTO(1001, "Tom", "01043211234");
			
			String result = g.toJson(dto);
			response.getWriter().append(result);
		} else if (cmd.equals("/exam06.ajax")) {
			System.out.println("객체배열 데이터 요청 확인");
			List<ContactDTO> list = new ArrayList<>();
			list.add(new ContactDTO(1001, "Tom", "01043211234"));
			list.add(new ContactDTO(1002, "Jane", "01012344321"));
			list.add(new ContactDTO(1003, "Mike", "01001000101"));
			
			String result = g.toJson(list);
			response.getWriter().append(result);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
