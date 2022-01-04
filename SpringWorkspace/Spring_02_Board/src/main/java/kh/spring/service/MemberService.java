package kh.spring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;
import kh.spring.utils.EncryptUtils;

@Service
public class MemberService {
	
	@Autowired
	public MemberDAO mdao;
	
//	@Autowired 세션은 웹티어에 해당한다. 여기로 오면 안됨
//	private HttpSession session;
	
	public int idDuplCheck(String id) {
		return mdao.idDuplCheck(id);
	}
	
	public int signUp(MemberDTO dto) {
		dto.setPw(EncryptUtils.getSHA512(dto.getPw())); // 패스워드 받자마자 암호화
		return mdao.signUp(dto);
	}
	
	public int login(String id, String pw) {
		return mdao.login(id, EncryptUtils.getSHA512(pw));
	}
	
	public int leave(String id) {
		return mdao.leave(id);
	}
	
	public MemberDTO getInfoByID(String id) {
		return mdao.getInfoByID(id);
	}
	
	public int modifyMyInfo(MemberDTO dto) {
		return mdao.modifyMyInfo(dto);
	}
}
