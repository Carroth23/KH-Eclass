package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.MoviesDTO;

public class MoviesDAO {
	
	private BasicDataSource bds = new BasicDataSource(); // Connection pool
	
	private static MoviesDAO instance = null;
	public static MoviesDAO getInstance() {
		if (instance == null) {
			instance = new MoviesDAO();
		}
		return instance;
	}
	private MoviesDAO() { // 연결할때 생성자로써 한번만 정보입력.
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@175.123.204.32:1521:xe");
		bds.setUsername("practice");
		bds.setPassword("practice");
		bds.setInitialSize(30); // 커넥션 풀 안에 몇개의 커넥션을 만들어둘것인지.
	}

	private Connection getConnection() throws Exception {
		return bds.getConnection();
	}

	public int insert(MoviesDTO dto) throws Exception {
		String sql = "insert into movies values(movies_seq.nextval, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getDescription());
			pstat.setDate(3, dto.getReldate());
			return pstat.executeUpdate();
		}
	}

	public List<MoviesDTO> selectAll() throws Exception {
		String sql = "select * from movies order by 1";
		try (Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()) {
			List<MoviesDTO> list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Date rel_date = rs.getDate("rel_date");

				MoviesDTO dto = new MoviesDTO(id, title, description, rel_date);
				list.add(dto);
			}
			return list;
		}
	}

	public int delete(int id) throws Exception {
		String sql = "delete from movies where id = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, id);
			return pstat.executeUpdate();
		}
	}

	public int update(MoviesDTO dto) throws Exception {
		String sql = "update movies set title = ?, description = ?, rel_date = ? where id = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getDescription());
			pstat.setDate(3, dto.getReldate());
			pstat.setInt(4, dto.getId());
			return pstat.executeUpdate();
		}
	}

	public MoviesDTO searchId(int id1) throws Exception {
		String sql = "select * from movies where id = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, id1);
			try (ResultSet rs = pstat.executeQuery()) {
				MoviesDTO dto = null;
				if (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String description = rs.getString("description");
					Date rel_date = rs.getDate("rel_date");

					dto = new MoviesDTO(id, title, description, rel_date);
				}
				return dto;
			}
		}
	}

	public List<MoviesDTO> selectAll(String title1) throws Exception {
		String sql = "select * from movies where title = ? order by 1";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, title1);
			try (ResultSet rs = pstat.executeQuery()) {

				List<MoviesDTO> list = new ArrayList<>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String description = rs.getString("description");
					Date rel_date = rs.getDate("rel_date");

					MoviesDTO dto = new MoviesDTO(id, title, description, rel_date);
					list.add(dto);
				}
				return list;
			}
		}
	}
}