package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.statics.Statics;

@Repository
public class BoardDAO {
	@Autowired
	JdbcTemplate jdbc;

	public int getRecordCount() { // 총 게시글 수
		String sql = "select count(*) from board";
		return jdbc.queryForObject(sql, Integer.class);
	}

	public int getPageTotalCount() {
		int recordTotalCount = this.getRecordCount(); // 총 게시글수
		
		System.out.println("총 게시글 수 : " + recordTotalCount);
		
		int pageTotalCount = 0; // 총 페이지수 선언
		if (recordTotalCount % Statics.RECORD_COUNT_PER_PAGE == 0) { // 게시글이 딱 떨어질경우
			pageTotalCount = recordTotalCount / Statics.RECORD_COUNT_PER_PAGE;
		} else { // 아닐경우
			pageTotalCount = recordTotalCount / Statics.RECORD_COUNT_PER_PAGE + 1;
		}
		return pageTotalCount;
	}

	public List<BoardDTO> selectByBound(int start, int end) {
		String sql = "select * from (select board.*, row_number() over(order by seq desc) AS rn from board) where rn between ? and ?";
		return jdbc.query(sql, new RowMapper<BoardDTO>() {
			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setWrite_date(rs.getDate("write_date"));
				dto.setView_count(rs.getInt("view_count"));
				return dto;
			}
		}, start, end);
	}
	
	public String getPageNavi(int currentPage) {
		int pageTotalCount = this.getPageTotalCount(); // 총 페이지 갯수
		// 현재페이지에서 보이는 네비의 첫 번호
		int startNavi = (currentPage - 1) / Statics.NAVI_COUNT_PER_PAGE * Statics.NAVI_COUNT_PER_PAGE + 1;
		int endNavi = startNavi + (Statics.NAVI_COUNT_PER_PAGE - 1);
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		String pageNavi = "";
		if(needPrev) {
			pageNavi += "<a href='/board/list?cpage=" + (startNavi-1) + "'><</a>";
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			pageNavi += "<a href='/board/list?cpage=" + i + "'> " + i + " </a>";
		}
		
		if(needNext) {
			pageNavi += "<a href='/board/list?cpage=" + (endNavi + 1) + "'>></a>";
		}
		return pageNavi;
	}
	
	
}
