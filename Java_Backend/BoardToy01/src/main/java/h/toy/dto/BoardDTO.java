package h.toy.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BoardDTO {
	private int seq;
	private String writer;
	private String title;
	private String contents;
	private Date write_Date;
	private int view_Count;

	public BoardDTO() {
		super();
	}

	public BoardDTO(int seq, String writer, String title, String contents, Date write_Date, int view_Count) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.write_Date = write_Date;
		this.view_Count = view_Count;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getWrite_Date() {
		return write_Date;
	}

	public void setWrite_Date(Date write_Date) {
		this.write_Date = write_Date;
	}

	public int getView_Count() {
		return view_Count;
	}

	public void setView_Count(int view_Count) {
		this.view_Count = view_Count;
	}

	public String getFormedDate() { // 날짜값 내가 정해서 꺼내는것
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		return sdf.format(this.write_Date.getTime());
	}

	public String getDetailDate() { // 몇분전 몇시간전 이런식으로 작성일 꺼내는거
		long current_time = System.currentTimeMillis(); // 현재의 TimeStamp
		long write_time = this.write_Date.getTime(); // 글이 작성된 시점의 TimeStamp

		long time_gap = current_time - write_time; // 작성된 시점과 현재시간의 갭

		if (time_gap < 60000) {
			return "1분 이내";
		} else if (time_gap < 300000) {
			return "5분 이내";
		} else if (time_gap < 3600000) {
			return "1시간 이내";
		} else if (time_gap < 86400000) {
			return "오늘";
		} else {
			return getFormedDate();
		}

	}
}
