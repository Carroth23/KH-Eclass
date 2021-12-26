package toy.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import toy.board.dto.BorDTO;
import toy.board.statics.Statics;

public class BorDAO {
	private static BorDAO instance = null;

	public static BorDAO getInstance() {
		if (instance == null) {
			instance = new BorDAO();
		}
		return instance;
	}

	private BorDAO() {
	}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	public int getTotalRowCount() throws Exception { // 총 게시글 갯수
		String sql = "select count(*) from board";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()) {
			rs.next();
			return rs.getInt(1);
		}
	}

	public int getTotalPageCount() throws Exception { // 총 페이지 갯수
		int rowTotalCount = this.getTotalRowCount();
		int pageTotalCount = 0;
		if (rowTotalCount % Statics.ROW_COUNT_PER_PAGE == 0) {
			pageTotalCount = rowTotalCount / Statics.ROW_COUNT_PER_PAGE;
		} else if (rowTotalCount % Statics.ROW_COUNT_PER_PAGE != 0) {
			pageTotalCount = rowTotalCount / Statics.ROW_COUNT_PER_PAGE + 1;
		}
		return pageTotalCount;
	}
	
	public String getPageNavi(int currentPage) throws Exception {
		int pageTotalCount = this.getTotalPageCount(); // 전체페이지
		
		int startNavi = (currentPage - 1) / Statics.NAVI_COUNT_PER_PAGE * Statics.NAVI_COUNT_PER_PAGE + 1; // 시작페이지 1일때 1, 14일때 11, 45일때 41 
		int endNavi = startNavi + (Statics.NAVI_COUNT_PER_PAGE - 1); // 네비의 끝페이지
		
		if (endNavi > pageTotalCount) {endNavi = pageTotalCount;} // 마지막 페이지 방어
		
		// 화살표
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {needPrev = false;}
		if (endNavi == pageTotalCount) {needNext = false;}
		
		String pageNavi = "";
		if (needPrev) {
			pageNavi += "<a href='/boardList.board?cpage=" + (startNavi - 1) + "'> < </a>";
		}
		for (int i = startNavi; i <= endNavi; i++) {
			pageNavi += "<a href='/boardList.board?cpage=" + i + "'>" + i + "</a>";
		}
		if (needNext) {
			pageNavi += "<a href='/boardList.board?cpage=" + (endNavi + 1) + "'> > </a>";
		}
		return pageNavi;
	}
	
	public List<BorDTO> selectByBound (int start, int end) throws Exception {
		String sql = "select * from (select board.*, row_number() over(order by seq desc) AS rn from board) where rn between ? and ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, start);
			pstat.setInt(2, end);
			try(ResultSet rs = pstat.executeQuery()){
				List<BorDTO> list = new ArrayList<>();
				while(rs.next()) {
					int seq = rs.getInt("seq");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					String writer = rs.getString("writer");
					int viewCount = rs.getInt("viewcount");
					int comment = rs.getInt("comments");
					int likeCount = rs.getInt("likecount");
					Date writeDate = rs.getDate("writeDate");
					BorDTO dto = new BorDTO(seq, title, contents, writer, viewCount, comment, likeCount, writeDate);
					list.add(dto);
				}
				return list;
			}
		}
	}
	
	

	public int insert(BorDTO dto) throws Exception { // 게시글 작성
		String sql = "insert into board values(boardseq.nextval, ?, ?, ?, 0, 0, 0, sysdate)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContents());
			pstat.setString(3, dto.getWriter());
			return pstat.executeUpdate();
		}
	}

	public List<BorDTO> boardSelectAll() throws Exception { // 전체 게시글 다뽑아오기
		String sql = "select * from board order by 1 desc";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()) {
			List<BorDTO> list = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				int viewCount = rs.getInt("viewcount");
				int comment = rs.getInt("comments");
				int likeCount = rs.getInt("likecount");
				Date writeDate = rs.getDate("writeDate");
				BorDTO dto = new BorDTO(seq, title, contents, writer, viewCount, comment, likeCount, writeDate);
				list.add(dto);
			}
			return list;
		}
	}

	public int viewCountUp (int seq) throws Exception { // 조회수 하나 올리고
		String sql = "update board set viewcount = viewcount + 1 where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, seq);
			return pstat.executeUpdate();
		}
	}
	
	public BorDTO selectOnePost (int seq) throws Exception { // 해당하는 글 하나 클릭
		String sql = "select * from board where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat =con.prepareStatement(sql)){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery()){
				rs.next();
				return new BorDTO(seq, rs.getString("title"), rs.getString("contents"), rs.getString("writer"), rs.getInt("viewcount"), 
						rs.getInt("comments"), rs.getInt("likecount"), rs.getDate("writeDate"));
			}
		}
	}

}
