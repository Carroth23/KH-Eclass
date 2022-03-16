package kh.spring.dto;

import java.sql.Date;

public class ReplyDTO {
	private int seq;
	private int board_seq;
	private String writer;
	private String contents;
	private Date write_date;
	public ReplyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyDTO(int seq, int board_seq, String writer, String contents, Date write_date) {
		super();
		this.seq = seq;
		this.board_seq = board_seq;
		this.writer = writer;
		this.contents = contents;
		this.write_date = write_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
}
