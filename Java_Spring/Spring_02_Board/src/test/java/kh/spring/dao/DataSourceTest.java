package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// import 부분은 올바르게 되어져 있다는 전제하므로 생략하기로 함.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DataSourceTest {
	@Autowired
	private DataSource dataSource;
	
	public void testQuery() throws Exception {
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement pstmt = conn
					.prepareStatement("select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'), username from user_users");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println("현재시각 : " + rs.getString(1));
			System.out.println("사용자명 : " + rs.getString(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}