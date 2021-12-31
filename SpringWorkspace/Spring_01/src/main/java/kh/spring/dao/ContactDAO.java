package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ContactDTO;

// 컴포넌트가 아닌 리파지토리를 붙여도 똑같이 작동함 ㅎㅎ Repository는 결국 컴포넌트를 상속받은 것
// 미래를 위해 컴포넌트로만 묶는게 아닌 독단적인 기능별로 묶어서 쓸려고 나눈것.
// 스프링 DAO는 Repository로 받자.
@Repository
public class ContactDAO {

	// MyBatis 방식
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insert(ContactDTO dto) { // 인서트
		// 첫 인자는 Contact란 namespace에 insert란 아이디를 가진 녀석을 사용하겠다라고 명세한다.
		return mybatis.insert("Contact.insert", dto);
		// int seq = ~~~~;
		// String name = ~~~~;
		// String contact = ~~~;
		// dto도 hashmap이랑 비슷하게 key값, value값으로 들어감
	}

	// 테이블의 컬럼명과 DTO의 필드명이 동일해야함.
	public List<ContactDTO> selectAll() {
		return mybatis.selectList("Contact.selectAll");
	}

	public int selectCount() {
		return mybatis.selectOne("Contact.selectCount"); // 하나만 뽑으니까 selectOne
	}

	public int deleteBySeq(int seq) {
		return mybatis.delete("Contact.deleteBySeq", seq);
	}

	public int update(String column, String value, int seq) { // update는 인자값을 하나만 받는데 우린 넘길게 여러개일때.

		// key : value 식으로 들어가기때문에 제너릭이 두개다.(JSON이랑 비슷한 녀석임)
		Map<String, String> map = new HashMap<>();
		map.put("column", column);
		map.put("value", value);
		map.put("seq", String.valueOf(seq));
		// {column:~~~, value:~~~~, seq:~~~~}
		return mybatis.update("Contact.update", map);
	}

	public List<ContactDTO> search(int seq) {
		return mybatis.selectList("Contact.selectBySeq", seq);
//		mybatis.selectOne("Contact.selectByKeyword", keyword); 하나만 꺼내는 상황이라면.
	}

	public List<ContactDTO> searchByMultiCon(ContactDTO dto) {
		return mybatis.selectList("Contact.searchByMultiCon", dto);
	}

	
	
	
	
////////////////////////////////////////////////////////////

//	SpringJDBC를 이용한 방식
//	@Autowired
//	private JdbcTemplate jdbc; // spring jdbc
//
//	public int insert(ContactDTO dto) throws Exception {
//		String sql = "insert into contact values(contact_seq.nextval, ?, ?)";
//		return jdbc.update(sql, dto.getName(), dto.getContact()); // insert, update, delete는 update란 명령어를 쓴다.
//		// 첫번째에 sql문을 넣고 그 다음 물음표, 또 그 다음 물음표 (close나 그런거 다 자동으로 해줌{가변인자})
//	}
//	
//	public int selectCount() throws Exception {
//		String sql = "select count(*) from contact";
//		return jdbc.queryForObject(sql, Integer.class); // 내가 쿼리를 날리고 받아오는값이 Integer다.
//	}
//
//	public List<ContactDTO> selectAll() throws Exception {
//		String sql = "select * from contact";
//		return jdbc.query(sql, new RowMapper<ContactDTO>() { // RowMapper는 인터페이스인데 밑에서 오버라이드해서 구현시킴.그래서 new 쌉가능
//			// 메서드가 다른 메서드를 원하는 콜백패턴이다. 자바스크립트의 콜백과 비슷
//			// 자바에서는 함수를 넘길 수 없으니 함수를 구현한 인스턴스를 넘긴다.(자스는 함수를 넘길 수 있음.{퍼스트클래스 펑-션})
//			@Override
//			public ContactDTO mapRow(ResultSet rs, int rowNum) throws SQLException { // 제너릭 가능
//				ContactDTO dto = new ContactDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setName(rs.getString("name"));
//				dto.setContact(rs.getString("contact"));
//				return dto;
//			}
//		});
//		// jdbc.query : List 데이터를 가져올 때 사용
//		// jdbc.queryForObject : 한개의 데이터를 가져올 때 사용한다. (DTO, int...)
//	}
//	
//	public List<ContactDTO> search(int seq) throws Exception { // 꺼내오면서 인자값도 전달해야 하는 경우 저렇게 쓴다.
//		String sql = "select * from contact where seq = ?";
//		return jdbc.query(sql, new RowMapper<ContactDTO>() {
//			@Override
//			public ContactDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				ContactDTO dto = new ContactDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setName(rs.getString("name"));
//				dto.setContact(rs.getString("contact"));
//				return dto;
//			}
//		}, seq);
//		
//		// 하나의 데이터를 검색하는게 확정되는 경우
////		return jdbc.queryForObject(sql, new RowMapper<ContactDTO>() {
////			@Override
////			public ContactDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
////				ContactDTO dto = new ContactDTO();
////				dto.setSeq(rs.getInt("seq"));
////				dto.setName(rs.getString("name"));
////				dto.setContact(rs.getString("contact"));
////				return dto;
////			}
////		}, seq);
//	}
//	
//	public int delete(int seq) throws Exception {
//		String sql = "delete from contact where seq = ?";
//		return jdbc.update(sql, seq);
//	}
//	
//	public int update(ContactDTO dto) throws Exception {
//		String sql = "update contact set name = ?, contact = ? where seq = ?";
//		return jdbc.update(sql, dto.getName(), dto.getContact(), dto.getSeq());
//	}

////////////////////////////////////////////////////

// 옛날 DBCP방식을 이용한 코드들 ///////
//	@Autowired // 스프링 인스턴스 풀 안에 있는 인스턴스를 자동으로 집어넣음.(dependency Injection DI 디펜던시 인젝션)
//	private BasicDataSource bds;

//	public int insert(ContactDTO dto) throws Exception {
//		String sql = "insert into contact values(contact_seq.nextval,?,?)";
//		try(Connection con = bds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql)){
//			pstat.setString(1, dto.getName());
//			pstat.setString(2, dto.getContact());
//			return pstat.executeUpdate();
//		}
//	}
//	
//	public int update(ContactDTO dto) throws Exception {
//		String sql = "update contact set name=?, contact=? where seq=?";
//		try(Connection con = bds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql)){
//			pstat.setString(1, dto.getName());
//			pstat.setString(2, dto.getContact());
//			pstat.setInt(3, dto.getSeq());
//			return pstat.executeUpdate();
//		}
//	}
//	
//	public List<ContactDTO> selectAll() throws Exception {
//		String sql = "select * from contact";
//		try(Connection con = bds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql);
//				ResultSet rs = pstat.executeQuery()){
//			List<ContactDTO> list = new ArrayList<>();
//			while(rs.next()) {
//				int seq = rs.getInt("seq");
//				String name = rs.getString("name");
//				String contact = rs.getString("contact");
//				list.add(new ContactDTO(seq, name, contact));
//			}
//			return list;
//		}
//	}
//	
//	public int delete(int seq) throws Exception{
//		String sql = "delete from contact where seq = ?";
//		try(Connection con = bds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql)){
//			pstat.setInt(1, seq);
//			return pstat.executeUpdate();
//		}
//	}

}
