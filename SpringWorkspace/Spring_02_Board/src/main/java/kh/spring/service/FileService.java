package kh.spring.service;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.FilesDAO;
import kh.spring.dto.FilesDTO;

@Service
public class FileService {
	
	@Autowired
	private FilesDAO fdao;
	
	public int insert(FilesDTO dto) {
		return fdao.insert(dto);
	}
	
	public List<FilesDTO> selectFileBySeq(int seq) {
		return fdao.selectFileBySeq(seq);
	}
	
	public byte[] getFileContents(String realPath, String sysName, String oriName) throws Exception {
		File target = new File(realPath+"/"+sysName);							// sysName 와 결합하여 대상 파일 객체 생성
		byte[] fileContents = new byte[(int)target.length()];
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target))) {	// 대상 파일에 대한InputStream 개방){
				dis.readFully(fileContents);											// 대상 파일 로딩
				return fileContents;
		}
	}
	
	public String getEncodedOriName(String oriName) throws Exception {
		return oriName = new String(oriName.getBytes(), "ISO-8859-1");					// 인코딩
	}
}
