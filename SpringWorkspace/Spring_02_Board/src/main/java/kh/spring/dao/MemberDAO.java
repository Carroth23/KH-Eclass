package kh.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

//컴포넌트가 아닌 리파지토리를 붙여도 똑같이 작동함 ㅎㅎ Repository는 결국 컴포넌트를 상속받은 것
//미래를 위해 컴포넌트로만 묶는게 아닌 독단적인 기능별로 묶어서 쓸려고 나눈것.
//스프링 DAO는 Repository로 받자.
@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public int idDuplCheck(String id) {
		return mybatis.selectOne("Member.idDuplCheck", id);
	}

	public int signUp(MemberDTO dto) {
		return mybatis.update("Member.signUp", dto);
	}

	public int login(String id, String pw) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return mybatis.selectOne("Member.login", map);
	}

	public int leave(String id) {
		return mybatis.update("Member.leave", id);
	}

	public MemberDTO getInfoByID(String id) {
		return mybatis.selectOne("Member.getInfoByID", id);
	}

	public int modifyMyInfo(MemberDTO dto) {
		return mybatis.update("Member.modifyMyInfo", dto);
	}
}
