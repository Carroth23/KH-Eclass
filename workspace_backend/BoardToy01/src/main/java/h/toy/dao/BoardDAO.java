package h.toy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import h.toy.dto.BoardDTO;
import h.toy.statics.Statics;

public class BoardDAO {
	private static BoardDAO instance = null;
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	private BoardDAO() {}
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	// 보드관련
	private int getTotalRow() throws Exception { // 전체 게시글 수를 알아내는 메서드
		String sql = "select count(*) from board";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()) {
			rs.next(); // rs.next로 한칸 내리고
			return rs.getInt(1); // 거기서 첫번째 값을 가져옴(전체글 카운트 된 숫자)
		}
	}
	
	public int getTotalPage() throws Exception { // 페이지 수를 계산하는 메서드
		int totalPost = this.getTotalRow();
		int totalPage = 0;
		if(totalPost % Statics.ROW_PER_PAGE == 0) {
			totalPage = totalPost / Statics.ROW_PER_PAGE; // 총 게시글 수가 한 페이지에 보여줄 게시글수로 나눠 0으로 떨어지면 그게 게시판 페이지 수
		} else {
			totalPage = totalPost / Statics.ROW_PER_PAGE + 1; // 게시글수가 좀 더 많으면 페이지 수를 +1 해줌
		}
		return totalPage;
	}
	
	public String getPageNavi(int currentPage) throws Exception {
		int pageTotalCount = this.getTotalPage();
		
		int startNavi = (currentPage - 1) / Statics.NAVI_PER_PAGE * Statics.NAVI_PER_PAGE + 1;
		int endNavi = startNavi + (Statics.NAVI_PER_PAGE - 1);
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {needPrev = false;}
		if (endNavi == pageTotalCount) {needNext = false;}
		
		String pageNavi = "";
		if(needPrev) {
			pageNavi += "<a href='/toboard.board?cpage=" + (startNavi - 1) + "'>< </a>";
		}
		for (int i = startNavi; i <= endNavi; i++) {
			pageNavi += "<a href='/toboard.board?cpage=" + i + "'>" + i + "</a> ";
		}
		if (needNext) {
			pageNavi += "<a href='/toboard.board?cpage=" + (endNavi + 1) + "'> > </a>";
		}
		
		return pageNavi;
		
	}
	
	public List<BoardDTO> selectAll(int start, int end) throws Exception {
		String sql = "select * from (select board.*, row_number() over(order by seq desc) AS rn from board) where rn between ? and ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, start);
			pstat.setInt(2, end);
			try (ResultSet rs = pstat.executeQuery()){
				List<BoardDTO> list = new ArrayList<>();
				while(rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					Date write_Date = rs.getDate("write_date");
					int view_Count = rs.getInt("view_count");
					list.add(new BoardDTO(seq, writer, title, contents, write_Date, view_Count));
				}
				return list;
			}
		}
	}
	
	public BoardDTO detail (int seq) throws Exception {
		String sql = "select * from board where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, seq);
			try (ResultSet rs = pstat.executeQuery()) {
				BoardDTO dto = null;
				rs.next();
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Date write_date = rs.getDate("write_date");
				int view_count = rs.getInt("view_count");
				dto = new BoardDTO(seq, writer, title, contents, write_date, view_count);
				return dto;
			}
		}
	}
	
	public int addViewCount(int seq) throws Exception {
		String sql = "update board set view_count + 1 where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, seq);
			return pstat.executeUpdate();
		}
	}
}
