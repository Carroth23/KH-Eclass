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
		System.out.println("요청 URI : " + uri);
		String ctx = request.getContextPath();
		System.out.println("요청 CTX : " + ctx);
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);

//		MemberDAO dao = MemberDAO.getInstance(); 필요하면 쓸거
		BoardDAO dao = BoardDAO.getInstance();
		try {
			if (cmd.equals("/toboard.board")) { // board눌렀을때 오는곳
				
				List<BoardDTO> dto = dao.selectAll();
				request.setAttribute("post_List", dto); // 작성된 글목록 불러와서 request에 담아버리기
				request.getRequestDispatcher("/board/toBoard.jsp").forward(request, response);
//				response.sendRedirect("/board/toBoard.jsp"); 포워드시켜야될듯 ㅎㅎ
				
			} else if (cmd.equals("/boardWrite.board")) { // 작성하기 눌렀을때 오는곳.
				System.out.println("여기 옴");
				response.sendRedirect("/board/boardWrite.jsp");

			} else if (cmd.equals("/writeComplete.board")) {
				// 게시판 목록에서 아예 데이터베이스를 만들고 여기서 DB에 추가만 하면 될듯 ㅎㅎㅎ
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
