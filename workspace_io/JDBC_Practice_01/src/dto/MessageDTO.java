package dto;

public class MessageDTO {
	private int seq;
	private String writer;
	private String message;

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

	public MessageDTO() {
	}

	public MessageDTO(int seq, String writer, String message) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.message = message;
	}

}
