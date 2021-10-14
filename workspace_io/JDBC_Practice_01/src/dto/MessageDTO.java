package dto;

import java.sql.Date;

public class MessageDTO {
	private int seq;
	private String writer;
	private String message;
	private Date visit_date;

	public MessageDTO() {
		super();
	}

	public MessageDTO(int seq, String writer, String message, Date visit_date) {
		this.seq = seq;
		this.writer = writer;
		this.message = message;
		this.visit_date = visit_date;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}

}
