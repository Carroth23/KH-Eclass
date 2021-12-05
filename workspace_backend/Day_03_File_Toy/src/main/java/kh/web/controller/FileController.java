package kh.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.web.dao.FileDAO;
import kh.web.dto.FileDTO;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getServletPath();
		System.out.println("요청한 주소 : " + cmd);

		FileDAO dao = FileDAO.getInstance();

		try {
			if (cmd.equals("/upload.file")) {

				// 클라이언트는 인코딩해서 보냈지만 여기선 아직 그걸 분석할 능력이 없음.(그래서 라이브러리 필요)
				// cos.jar 얜 지금 좀 편함 나중엔 아파치꺼 쓸거
				// apache file-upload 얘는 Spring-framework랑 같이써야 편함(안그럼 드럽게 불편)
				// 이 두개가 젤 유명한 라이브러리
				int maxSize = 1024 * 1024 * 10; // 업로드 파일 크기 최대10 mb설정 // files 붙여주면 제3의경로
				String savePath = request.getServletContext().getRealPath("files"); // home폴더는 톰캣이 여러
																					// 파일(jsp,html,서블릿등등)들을 모아두는 폴더를 복사한
																					// 제 3의 폴더(이건 파일 경로 설정)
				System.out.println(savePath); // 얘가 제3의 폴더 주소 // 결국 클라이언트는 복사된 제3의 폴더로 접속하는것. 클라이언트가 올리는 파일도 여기에 저장된다.
				File filePath = new File(savePath); // 파일을 저장할 경로 설정
				if (!filePath.exists()) {
					filePath.mkdir();
				} // 제3의경로에 파일폴더가 없으면 만들어라.
				MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8",
						new DefaultFileRenamePolicy()); // 기본 리퀘스트를 파일도 분석할수있게 업그레이드, 업로드 파일을 지정경로에 저장기능까지
				// 업그레이드 할 request, 파일이 저장될 주소, 각 파일의 최대 사이즈, 인코딩 타입, 중복파일이 발생할 경우 알아서 파일명을 순서대로
				// 바꿔주는것(덮어씌워지지않게)

				// 파일 업로드말고 다운로드기능에서 알아야할것듯
				// seq 번호 하나 설정해서 설정해줘야됨
				// 업로드 당시의 파일 원래 이름 (original File Name)
				// 업로드 되었을 때 저장된 실제 파일 이름 (system file name)
				// 어느 게시글에 올린 파일인지(파일의 parent seq)(글지우면 그 파일도 같이 지워져야 하니까)
				// 이 위는 거의 필수 사항

				// 업로드 날짜 시간, 파일 사이즈(얘넨 선택사항)

				// DB에 저장할때와 가져올때 파일 이름을 알아야 하기 때문에 여기서 값을 얻음
				String oriName = multi.getOriginalFileName("file");
				String sysName = multi.getFilesystemName("file"); // 넘어온 파일의 name="name"값
				dao.insert(new FileDTO(0, oriName, sysName, 0));
				
				response.sendRedirect("/index.jsp");
			} else if (cmd.equals("/list.file")) {
				
				List<FileDTO> list = dao.selectAll();
				Gson g = new Gson();
				String result = g.toJson(list);
				response.setContentType("text/html;charset=utf8;"); // ajax 한글 처리 코드
				response.getWriter().append(result);
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
