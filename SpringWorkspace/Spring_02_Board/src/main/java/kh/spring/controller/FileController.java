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
	
	@RequestMapping("download")			// 디스패쳐한테 안보낼거라 response 생성함
	public void download(HttpServletResponse response, String oriName, String sysName) throws Exception {
		String realPath = session.getServletContext().getRealPath("upload");	// 파일 위치 경로를 획득
		File target = new File(realPath+"/"+sysName);							// sysName 와 결합하여 대상 파일 객체 생성
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));	// 대상 파일에 대한InputStream 개방
				DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
			
			byte[] fileContents = new byte[(int)target.length()];					// 대상 파일을 적재할 메모리공간 확보
			dis.readFully(fileContents);											// 대상 파일 로딩
			
			oriName = new String(oriName.getBytes(), "ISO-8859-1");					// 인코딩
			response.reset(); // 리스폰스 한번 비우고(안비우면 아마 바로띄울듯)
			response.setHeader("Content-Disposition", "attachment;filename="+oriName); // 돌려주는 이름
			
			dos.write(fileContents); // 로딩한 파일 올리고
			dos.flush(); // 보냄
		}
	}
}
