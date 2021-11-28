package kh.web.dto;

import java.sql.Date;

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
}
