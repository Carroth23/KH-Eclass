package quiz_Login;

import java.sql.Date;

public class Q01DTO {
	private String id;
	private String pw;
	private String name;
	private Date signup_date;

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

	public Date getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(Date signup_date) {
		this.signup_date = signup_date;
	}

	public Q01DTO(String id, String pw, String name, Date signup_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.signup_date = signup_date;
	}

	public Q01DTO() {}

}
