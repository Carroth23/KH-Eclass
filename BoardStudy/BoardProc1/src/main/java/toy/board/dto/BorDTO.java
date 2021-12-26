package toy.board.dto;

import java.sql.Date;

public class BorDTO {
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private int viewCount;
	private int comments;
	private int likeCount;
	private Date writeDate;
	public BorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorDTO(int seq, String title, String contents, String writer, int viewCount, int comments, int likeCount,
			Date writeDate) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.viewCount = viewCount;
		this.comments = comments;
		this.likeCount = likeCount;
		this.writeDate = writeDate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
}
