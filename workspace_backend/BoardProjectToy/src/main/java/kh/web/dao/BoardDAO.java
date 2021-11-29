package kh.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.web.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO instance = null;

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	private BoardDAO() {
	};

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	public int insert(BoardDTO dto) throws Exception { // 글을 작성하는 메서드
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, ?)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContents());
			pstat.setInt(4, dto.getView_Count());
			return pstat.executeUpdate();
		}
	}

	public List<BoardDTO> selectAll() throws Exception { // 모든 글을 꺼내오는 메서드
		String sql = "select * from board order by seq desc"; // 역순으로 해야 최신글이 위로 온다.
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()) {
			List<BoardDTO> dto = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date write_Date = rs.getDate("write_date");
				int view_Count = rs.getInt("view_count");
				dto.add(new BoardDTO(seq, writer, title, contents, write_Date, view_Count));
			}
			return dto;
		}
	}

	public BoardDTO selectBySeq(int seq) throws Exception { // 선택한 글
		String sql = "select * from board where seq = ?"; // 역순으로 해야 최신글이 위로 온다.
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, seq);
			try (ResultSet rs = pstat.executeQuery()) {
				BoardDTO dto = null;
				if (rs.next()) {
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					Date write_Date = rs.getDate("write_date");
					int view_Count = rs.getInt("view_count");
					dto = new BoardDTO(seq, writer, title, contents, write_Date, view_Count);
				}
				return dto;
			}
		}
	}

	public int addViewCount(int seq) throws Exception {
		String sql = "update board set view_count = view_count + 1 where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public int delete(int seq) throws Exception {
		String sql = "delete from board where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, seq);
			return pstat.executeUpdate();
		}
	}
}
