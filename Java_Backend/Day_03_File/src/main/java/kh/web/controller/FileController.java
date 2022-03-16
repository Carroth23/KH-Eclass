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

				multi.getParameter("name"); // index에서 인코딩을 multi로 설정해줬으면 여기서도 얘로 꺼내야 잘 꺼내진다
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

			} else if (cmd.equals("/download.file")) {

				String path = request.getServletContext().getRealPath("files"); // 파일이 저장되어 있는 경로
				String targetFileName = request.getParameter("sysName"); // 다운 받을 파일의 sysName
				String targetOriName = request.getParameter("oriName");
				
				// targetOriName = new String(targetOriName.getBytes("utf8"),"ISO-8859-1"); // 파일의 이름을 utf8에서 iso8859로 재조립 하라.(크롬은 어태치먼트로 받는건 isd8859로 인식해서.)
				// 위 주석 풀면 한글제목파일도 제대로 나옴
				
				File targetFile = new File(path + "/" + targetFileName); // 경로와 이름을 합쳐서 타겟을 지정
				System.out.println(targetFile);
				
				response.reset(); // 파일은 브라우저가 렌더링 하면 안되기 때문에 response를 비워버림 그 후 새 response만들듯
				response.setHeader("Content-Disposition", "attachment; filename=\"" + targetOriName + "\""); // 내가 지금 보내는건 첨부파일이니 화면에 띄우지 말고 다운받아라. 그리고 이 이름으로 저장해라.
				
				byte[] fileContents = new byte[(int)targetFile.length()]; // 하드디스크에 있는 파일을 복사해서 저장할 수 있는 공간만큼의 배열 확보
				  														  // 사이즈는 파일의 크기만큼
				
				try(ServletOutputStream sos = response.getOutputStream();
						DataInputStream dis = new DataInputStream(new FileInputStream(targetFile)); // 파일에 inputStream을 개방한 후(램이 기준이니까 하드 -> 램으로 올라온 다음 램에서 보내는거인듯)
						){
					dis.readFully(fileContents);	// 파일의 모든 내용 가져옴
					
					sos.write(fileContents);
					sos.flush();
				}
				
				
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
