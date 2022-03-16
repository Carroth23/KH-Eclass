package dto;

import java.sql.Date;

public class MoviesDTO {
	private int id;
	private String title;
	private String description;
	private Date reldate;

	public MoviesDTO() {
		super();
	}

	public MoviesDTO(int id, String title, String description, Date reldate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.reldate = reldate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReldate() {
		return reldate;
	}

	public void setReldate(Date reldate) {
		this.reldate = reldate;
	}
}
