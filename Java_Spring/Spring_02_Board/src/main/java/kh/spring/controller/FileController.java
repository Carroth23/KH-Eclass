package kh.spring.controller;

import java.io.DataOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.service.FileService;

@Controller
@RequestMapping("/file/")
public class FileController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private FileService fService;
	
	// 얘네도 서비스레이어로 빼야될듯
	@RequestMapping("download")			// 디스패쳐한테 안보낼거라 response 생성함
	public void download(HttpServletResponse response, String oriName, String sysName) throws Exception {
		String realPath = session.getServletContext().getRealPath("upload");	// 파일 위치 경로를 획득
		try(DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
			byte[] fileContents = fService.getFileContents(realPath, sysName, oriName);					// 대상 파일을 적재할 메모리공간 확보
			response.reset(); // 리스폰스 한번 비우고(안비우면 아마 바로띄울듯)
			response.setHeader("Content-Disposition", "attachment;filename="+fService.getEncodedOriName(oriName)); // 돌려주는 이름
			dos.write(fileContents); // 로딩한 파일 올리고
			dos.flush(); // 보냄
		}
	}
}
