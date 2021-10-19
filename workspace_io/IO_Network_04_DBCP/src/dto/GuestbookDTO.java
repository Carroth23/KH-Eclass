package dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class GuestbookDTO {
	private int seq;
	private String writer;
	private String message;
	private Date write_date;

	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(this.write_date);
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

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public GuestbookDTO(int seq, String writer, String message, Date write_date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.message = message;
		this.write_date = write_date;
	}

	public GuestbookDTO() {
		super();
	}

}
