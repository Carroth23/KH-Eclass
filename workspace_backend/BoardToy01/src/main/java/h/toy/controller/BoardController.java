package h.toy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import h.toy.dao.BoardDAO;
import h.toy.dto.BoardDTO;
import h.toy.statics.Statics;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getServletPath();
		System.out.println(cmd);
		BoardDAO dao = BoardDAO.getInstance();
		HttpSession session = request.getSession();
		
		try {
			if (cmd.equals("/toboard.board")) {
				String cpage = request.getParameter("cpage");
				if(cpage == null)cpage = "1";
				int currentPage = Integer.parseInt(cpage); // 현재페이지 인트로 변경
				if (currentPage < 1) {
					currentPage = 1;
				}
				if (currentPage > dao.getTotalPage()) {
					currentPage = dao.getTotalPage();
				}
				String navi = dao.getPageNavi(currentPage);
				request.setAttribute("navi", navi);
				
				int start = currentPage * Statics.ROW_PER_PAGE - (Statics.ROW_PER_PAGE - 1);
				int end = currentPage * Statics.ROW_PER_PAGE;
				List<BoardDTO> dto = dao.selectAll(start, end);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/board/toboard.jsp").forward(request, response);
				
			} else if (cmd.equals("/dtail.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				BoardDTO dto = dao.detail(seq);
				dao.addViewCount(seq);
				
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
