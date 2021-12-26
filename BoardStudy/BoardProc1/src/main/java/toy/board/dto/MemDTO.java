package toy.board.dto;

import java.sql.Date;

public class MemDTO {
	private int seq;
	private String id;
	private String pw;
	private String name;
	private Date signupDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
	public MemDTO(int seq, String id, String pw, String name, Date signupDate) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.signupDate = signupDate;
	}
	public MemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
