package kh.spring.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/")
public class FileController {

	@Autowired
	private HttpSession session; // 리얼패스를 얻어오는 방법은 세션으로도 얻어올수있다

	@RequestMapping("upload")
	public String upload(String title, String contents, MultipartFile[] file) throws Exception {
													// 멀티파트파일에 배열붙이면 여러개파일 오게하는것
		// MVC2때는 Http리퀘스트를 멀티파트로 업데이트시키기위해 cos.jar을 사용했었다.
		// 스프링에선 아파치 커먼스를 사용하는게 좋음

		for (MultipartFile mf : file) {
			if (!mf.isEmpty()) { // 업로드된 파일 중 첫 번째 파일이 비어있지 않다면 파일업로드 실행.(첨부안하고 완료해도 텅빈파일이 올라가기때문)
				String realPath = session.getServletContext().getRealPath("upload");
				File realPathFile = new File(realPath);
				System.out.println(realPathFile);
				if (!realPathFile.exists()) {
					realPathFile.mkdir(); // 만일 경로상에 지정한 폴더가 없다면 만들어라
				}

				String oriName = mf.getOriginalFilename(); // 사용자가 업로드 한 파일의 원본 이름
				// UUID.randomUUID(); // 절대 겹치지않는 무작위의 문자열을 만들어줌
				String sysName = UUID.randomUUID() + "_" + oriName; // 서버쪽에 저장할 파일 이름

				// 서버에 업로드되어 메모리에 적재된 파일의 내용을 어디에 저장할지 결정하는 부분
				mf.transferTo(new File(realPath + "/" + sysName));
			}
		}
		return "redirect:/";
	}
}
