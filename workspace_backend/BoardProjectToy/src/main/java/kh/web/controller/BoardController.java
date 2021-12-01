package kh.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.web.dao.BoardDAO;
import kh.web.dto.BoardDTO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);

//		MemberDAO dao = MemberDAO.getInstance(); 필요하면 쓸거
		BoardDAO dao = BoardDAO.getInstance();
		
		
//		try { 페이징연습을 위해 사용. 켜면 145개 글 등록되서 난리남
//			dao.insertDummy();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try {
			if (cmd.equals("/toboard.board")) { // board눌렀을때 오는곳
				
				// 게시판 입장시 1페이지를 보니까 1페이지를 받아온것(이게 현재 페이지가 된다.)
				int currentPage = Integer.parseInt(request.getParameter("cpage"));
				
//				1 -> 1 ~ 10
//				2 -> 11 ~ 20
				int start = currentPage * 10 - 9; // 10에는 recordCountPerPage를 써야됨
				int end = currentPage * 10;
				
				List<BoardDTO> dto = dao.selectByBound(start, end);
				String navi = dao.getPageNavi(currentPage); // 네비 dao
				
				request.setAttribute("post_List", dto); // 작성된 글목록 불러와서 request에 담아버리기
				request.setAttribute("navi", navi); // 네비도 속성값 부여
				request.getRequestDispatcher("/board/toBoard.jsp").forward(request, response);
//				response.sendRedirect("/board/toBoard.jsp"); 포워드시켜야될듯
				
			} else if (cmd.equals("/boardWrite.board")) { // 작성하기 눌렀을때 오는곳.
				System.out.println("여기 옴");
				response.sendRedirect("/board/boardWrite.jsp");

			} else if (cmd.equals("/writeComplete.board")) {
				// 게시판 목록에서 아예 데이터베이스를 만들고 여기서 DB에 추가만 하면 될듯
				HttpSession session = request.getSession();
				String writer = (String) session.getAttribute("loginID");
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				System.out.println(writer);
				System.out.println(title);
				System.out.println(contents);
				int result = dao.insert(new BoardDTO(0, writer, title, contents, null, 0));
				if(result > 0) {
					System.out.println("작성 완료");
					response.sendRedirect("/toboard.board"); // .board로 안보내고 페이지로 보내도 글이 올라오는지 확인해야됨 = 확인결과 .jsp로 바로보내면 안올라옴
				}
			} else if (cmd.equals("/detail.board")) {
				
				int seq = Integer.parseInt(request.getParameter("seq"));
				BoardDTO dto = dao.selectBySeq(seq); // seq와 동일한 작성글 하나를 꺼내온다.
				
				int result = dao.addViewCount(seq); // 조회수 올리기
				
				request.setAttribute("post_One", dto);
				request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
				
			} else if (cmd.equals("/delete.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				int result = dao.delete(seq);
				if (result > 0) {
					response.sendRedirect("/toboard.board");
				}
			} else if (cmd.equals("/modify.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				
				int result = dao.modify(seq, title, contents);
				response.sendRedirect("/detail.board?seq="+seq);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/member/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
