package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ContactDAO;
import kh.spring.dto.ContactDTO;

@Service
public class ContactService {
	
	@Autowired
	public ContactDAO cdao;
	
	public int insert(ContactDTO dto) {
		return cdao.insert(dto);
	}
	
	public List<ContactDTO> selectAll(){
		return cdao.selectAll();
	}
	
	public int selectCount() {
		return cdao.selectCount();
	}
	
	public List<ContactDTO> search(int seq){
		return cdao.search(seq);
	}
	
	public List<ContactDTO> searchByMultiCon(ContactDTO dto){
		return cdao.searchByMultiCon(dto);
	}
	
	public int deleteBySeq (int delTarget) {
		return cdao.deleteBySeq(delTarget);
	}
	
	public int update (String column, String value, int seq) {
		return cdao.update(column, value, seq);
	}
	
}
