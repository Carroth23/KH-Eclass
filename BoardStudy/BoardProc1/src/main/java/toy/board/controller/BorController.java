package toy.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import toy.board.dao.BorDAO;
import toy.board.dto.BorDTO;
import toy.board.statics.Statics;

@WebServlet("*.board")
public class BorController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getServletPath();
		HttpSession session = request.getSession();
		BorDAO dao = BorDAO.getInstance();
		try {
			if(cmd.equals("/boardList.board")) {
				
				System.out.println("로그인한 사용자 : " + session.getAttribute("loginId"));
				String cpage = request.getParameter("cpage");
				if(cpage == null) { // 현재페이지 지정
					cpage = "1";
				}
				int currentPage = Integer.parseInt(cpage); // 숫자로 바꾸고
				
				if(currentPage < 1) { // -1페이지로 입력해서 들어오는거 방어
					currentPage = 1;
				}
				if(currentPage > dao.getTotalPageCount()) { // 페이지 뒤에꺼 방어
					currentPage = dao.getTotalPageCount();
				}
				
				int start = currentPage * Statics.ROW_COUNT_PER_PAGE - (Statics.ROW_COUNT_PER_PAGE - 1);
				int end = currentPage * Statics.ROW_COUNT_PER_PAGE;
				String navi = dao.getPageNavi(currentPage);
				request.setAttribute("navi", navi);
				
				List<BorDTO> list = dao.selectByBound(start, end);
				
				
				request.setAttribute("list", list); // 리퀘스트에 넣고
				request.getRequestDispatcher("/board/boardList.jsp").forward(request, response); // 포워드
				
			} else if (cmd.equals("/boardWrite.board")) {
				
				System.out.println("글쓰러 이동");
				response.sendRedirect("/board/boardWrite.jsp");
				
			} else if (cmd.equals("/writeCom.board")) {
				
				String writer = (String) session.getAttribute("loginId");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				dao.insert(new BorDTO(0, title, content, writer, 0, 0, 0, null));
				System.out.println("작성 완료");
				response.sendRedirect("/boardList.board");
				
			} else if (cmd.equals("/detail.board")) {
				
				int seq = Integer.parseInt(request.getParameter("seq"));
				System.out.println("선택된 seq : " + seq);
				dao.viewCountUp(seq); // 조회수 올리고
				BorDTO dto = dao.selectOnePost(seq); // 게시글 하나 뽑아오기
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
