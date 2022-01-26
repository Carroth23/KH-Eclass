package kh.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration 얘를 빼면 컴포넌트 스캔 범위를 dao까지로 줄여야함. (톰캣이 없어서)session을 Autowired못하기때문
@ContextConfiguration(locations = { // 스프링 컨테이너 만드는것(톰캣 필요없이)
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void insertTest() {
		dao.signUp(new MemberDTO("ABCD1234","1234"));
	}
}
