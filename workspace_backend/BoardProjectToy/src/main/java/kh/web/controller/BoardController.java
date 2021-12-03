package kh.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.web.dao.BoardDAO;
import kh.web.dao.FileDAO;
import kh.web.dto.BoardDTO;
import kh.web.dto.FileDTO;
import kh.web.statics.Statics;

@WebServlet("*.board")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 얘는 걍 냅둘것
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		System.out.println("요청 CMD : " + cmd);

//		MemberDAO dao = MemberDAO.getInstance(); 필요하면 쓸거
		BoardDAO dao = BoardDAO.getInstance();
		FileDAO fdao = FileDAO.getInstance();
		
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
//				if(currentPage == null)currentPage = 1; // 여기서 설정하면 다 안바꿔도 됨
				
				if(currentPage < 1) {currentPage = 1;} // -1로 들어오는 페이지 방어
				if(currentPage > dao.getPageTotalCount()) {currentPage = dao.getPageTotalCount();}
				
//				1 -> 1 ~ 10
//				2 -> 11 ~ 20
				int start = currentPage * Statics.RECORD_COUNT_PER_PAGE - (Statics.RECORD_COUNT_PER_PAGE - 1);
				int end = currentPage * Statics.RECORD_COUNT_PER_PAGE;
				String navi = dao.getPageNavi(currentPage); // 네비 dao
				request.setAttribute("navi", navi); // 네비도 속성값 부여
				
				// 이쯤에서 검색으로 들어오는거 분기시켜보기
				String search = request.getParameter("search");
				if(search == null) {
					List<BoardDTO> dto = dao.selectByBound(start, end);
					request.setAttribute("post_List", dto); // 작성된 글목록 불러와서 request에 담아버리기
					
				} else {
					List<BoardDTO> dto = dao.selectBySearch(start, end, search);
					request.setAttribute("post_List", dto);
				}
				
				
				request.getRequestDispatcher("/board/toBoard.jsp").forward(request, response);
//				response.sendRedirect("/board/toBoard.jsp"); 포워드시켜야될듯
				
			} else if (cmd.equals("/boardWrite.board")) { // 작성하기 눌렀을때 오는곳.
				System.out.println("여기 옴");
				response.sendRedirect("/board/boardWrite.jsp");

			} else if (cmd.equals("/writeComplete.board")) {
				// 여기서부터 파일업로드 관련 코드
				int maxSize = 1024 * 1024 * 10;
				String savePath = request.getServletContext().getRealPath("files");
				System.out.println(savePath);
				File filePath = new File(savePath);
				
				if(!filePath.exists()) {
					filePath.mkdir();
				}
				
				// MultipartRequest 얘를 if 밖으로 빼버릴까 이거 질문(전부 이걸로 받을거면 빼도 됨)
				MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				multi.getParameter(savePath);
				String oriName = multi.getOriginalFileName("file");
				String sysName = multi.getFilesystemName("file");
				fdao.insert(new FileDTO(0, oriName, sysName, 0));
				// 여기까지 파일업로드 관련
				
				// 게시판 목록에서 아예 데이터베이스를 만들고 여기서 DB에 추가만 하면 될듯
				HttpSession session = request.getSession();
				String writer = (String) session.getAttribute("loginID");
//				String title = request.getParameter("title"); // multi 업글했으니 얘넨 못씀
//				String contents = request.getParameter("contents");
				String title = multi.getParameter("title");
				String contents = multi.getParameter("contents");
				
				int result = dao.insert(new BoardDTO(0, writer, title, contents, null, 0));
				
				if(result > 0) {
					System.out.println("작성 완료");
					response.sendRedirect("/toboard.board?cpage=1"); // .board로 안보내고 페이지로 보내도 글이 올라오는지 확인해야됨 = 확인결과 .jsp로 바로보내면 안올라옴
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
					response.sendRedirect("/toboard.board?cpage=1");
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
