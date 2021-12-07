package kh.web.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
				int detailseq = Integer.parseInt(request.getParameter("detailseq"));
				System.out.println(cmd);
				List<FileDTO> list = dao.selectSeqFiles(detailseq);
				Gson g = new Gson();
				String result = g.toJson(list);
				response.setContentType("text/html;charset=utf8;");
				response.getWriter().append(result);
			} else if (cmd.equals("/fileDown.file")) {
				String path = request.getServletContext().getRealPath("files");
				
				String sysName = request.getParameter("sysName");
				String oriName = request.getParameter("oriName");
				
				File targetFile = new File(path + "/" + sysName);
				response.reset();
				response.setHeader("Content-Disposition", "attachment; filename=\""+ oriName +"\"");
				
				byte[] fileContent = new byte[(int) targetFile.length()];
				
				try(ServletOutputStream sos = response.getOutputStream();
						DataInputStream dis = new DataInputStream(new FileInputStream(targetFile))){
					dis.readFully(fileContent);
					
					sos.write(fileContent);
					sos.flush();
				}
				
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
