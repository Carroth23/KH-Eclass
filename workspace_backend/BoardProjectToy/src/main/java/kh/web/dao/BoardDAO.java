package kh.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.web.dto.BoardDTO;
import kh.web.statics.Statics;

public class BoardDAO {
	private static BoardDAO instance = null;

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	private BoardDAO() {
	}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

//	public void insertDummy() throws Exception { // 페이징테스트를 위해 게시글 늘리기 pstat쓰면 for문 힘듬
//		
//		try(Connection con = this.getConnection();
//				Statement stat = con.createStatement()){
//			
//			for(int i = 1; i < 147; i++) {
//				stat.executeUpdate("insert into board values(board_seq.nextval, 'writer"+i+"','title"+i+"','내용',sysdate,default)");
//			}
//		}
//	}

	private int getRecordCount() throws Exception { // 게시글 몇개인지 알아내는 메서드
		String sql = "select count(*) from board";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {
			rs.next(); // next로 한 행 내리고
			return rs.getInt(1); // 거기에 첫번째에 나오는 카운트값을 리턴시킴
		}
	}
	
	public int getPageTotalCount() throws Exception{
		int recordTotalCount = this.getRecordCount(); // 총 몇개의 레코드(게시글)를 가지고 있는지?
		int pageTotalCount = 0; // 총 페이지의 갯수 정해두기
		if (recordTotalCount % Statics.RECORD_COUNT_PER_PAGE == 0) { // 총 페이지의 갯수(게시글 수 / 한페이지보여줄 글 갯수가 0으로 떨어지면 +1이 필요없다.)
			pageTotalCount = recordTotalCount / Statics.RECORD_COUNT_PER_PAGE;
		} else {
			pageTotalCount = recordTotalCount / Statics.RECORD_COUNT_PER_PAGE + 1;
		}
		return pageTotalCount;
	}

	public String getPageNavi(int currentPage) throws Exception { // currentPage(컨트롤러부터 받아온 현재페이지)
		
		int pageTotalCount = this.getPageTotalCount(); // 위에서 메서드로 만들어놨으니 그걸 받아옴

		// 현재 페이지에서 첫페이지 번호 (예를 들어 14에 있으면 11{요놈} ~ 20)
		int startNavi = (currentPage - 1) / Statics.NAVI_COUNT_PER_PAGE * Statics.NAVI_COUNT_PER_PAGE + 1;
		// 현재 페이지에서 끝에 나오는 페이지 번호 (예를 들어 14에 있으면 11 ~ 20{요놈})
		int endNavi = startNavi + (Statics.NAVI_COUNT_PER_PAGE - 1);

		// 공식에 의해 발생한 endNavi값이 실제 페이지 전체 개수보다 클 경우 조정
		if (endNavi > pageTotalCount) {endNavi = pageTotalCount;}

		// 다음, 이전 화살표(10개 페이지씩 넘기는)
		boolean needPrev = true;
		boolean needNext = true;

		// 시작네비가 1이 나오면 이전이 필요없다.
		if (startNavi == 1) {needPrev = false;}

		// 끝 네비가 총 페이지갯수와 같다면 다음이 필요없다.
		if (endNavi == pageTotalCount) {needNext = false;}

		// 네비 화살표와 번호 출력시키기
		String pageNavi = "";
		if (needPrev) {
			pageNavi += "<a href='/toboard.board?cpage=" + (startNavi - 1) + "'>< </a> ";
		}
		for (int i = startNavi; i <= endNavi; i++) {
			pageNavi += "<a href='/toboard.board?cpage=" + i + "'>" + i + "</a> ";
		}
		if (needNext) {
			pageNavi += "<a href='/toboard.board?cpage=" + (endNavi + 1) + "'>></a>";
		}
		// 만약 14페이지를 보고있다면, 시작네비가 11이므로 <화살표가 나와야 하고, 총 페이지의 갯수가 15개 이므로 >화살표는 나오지 않는다.

		return pageNavi;
	}

	public List<BoardDTO> selectByBound(int start, int end) throws Exception {
		String sql = "SELECT * FROM (SELECT board.*, row_number() over(order by seq desc) AS rn FROM board) WHERE rn between ? and ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, start);
			pstat.setInt(2, end);
			try (ResultSet rs = pstat.executeQuery()) {
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
	}
	
	public List<BoardDTO> selectBySearch(int start, int end, String search) throws Exception {
		String sql = "SELECT * FROM (SELECT board.*, row_number() over(order by seq desc) AS rn FROM board) WHERE rn between ? and ? and title like ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, start);
			pstat.setInt(2, end);
			pstat.setString(3, search);
			try (ResultSet rs = pstat.executeQuery()) {
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
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, seq);
			return pstat.executeUpdate();
		}
	}

	public int modify(int seq, String title, String contents) throws Exception {
		String sql = "update board set title = ?, contents = ? where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setString(1, title);
			pstat.setString(2, contents);
			pstat.setInt(3, seq);
			int result = pstat.executeUpdate();
			return result;
		}
	}

}
