package kh.spring.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file/")
public class FileController {

	@Autowired
	private HttpSession session;

	@RequestMapping("download")
	public void download(HttpServletResponse response, String oriName, String sysName) throws Exception {
		System.out.println("들어온 파일이름들 ori: " + oriName + " sys: " + sysName);
		String realPath = session.getServletContext().getRealPath("upload"); // 파일 위치 경로를 획득
		File target = new File(realPath + "/" + sysName); // sysName과 결합하여 대상 파일 객체 생성

		try (DataInputStream dis = new DataInputStream(new FileInputStream(target)); // 대상 파일에 대한 inputStream 개방
				DataOutputStream dos = new DataOutputStream(response.getOutputStream());) {
			byte[] fileContents = new byte[(int) target.length()]; // 대상파일을 적재할 메모리공간 미리 확보
			dis.readFully(fileContents); // 대상 파일 로딩
			
			oriName = new String(oriName.getBytes(), "ISO-8859-1"); // 크롬 인코딩
			
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename=" + oriName);
													// 어태치먼트: 내가보내는건 jsp가 아닌 파일이다.
			dos.write(fileContents);
			dos.flush();
		}
	}
}
