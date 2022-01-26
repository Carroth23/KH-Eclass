package kh.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 여기선 사용해야됨. 컨트로러기때문? 컴포넌트스캔도 재조정 필요
@ContextConfiguration(locations = { // 스프링 컨테이너 만드는것(톰캣 필요없이)
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext wac;	// Tomcat 환경정보를 담고있는 객체
	private MockMvc mockMvc;			// Tomcat 환경정보로부터 가짜 Request를 만들어줄 역할을 하는 객체
	
	@Before // AOP꺼 아님(Test 메서드들 보다 먼저 실행되어 초기값을 세팅해주는 역할)
	public void setup() {
		// 우리가 사용할 Tomcat 의 환경전보로부터 임의의 Request를 만들어내는 역활을 해주는 객체를 생성하는 과정(얜 아마 필수)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void boardListTest() throws Exception {
		
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("loginID", "Test");
		this.mockMvc.perform(get("/board/list").session(session)).andDo(print()).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void boardDeleteTest() throws Exception {
		this.mockMvc.perform(post("/board/delete").param("seq", "10")).andDo(print()).andExpect(status().is3xxRedirection());
	}
}
