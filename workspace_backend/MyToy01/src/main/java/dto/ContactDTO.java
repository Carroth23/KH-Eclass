package dto;

public class ContactDTO {
	private int seq;
	private String name;
	private String contat;

	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactDTO(int seq, String name, String contat) {
		super();
		this.seq = seq;
		this.name = name;
		this.contat = contat;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContat() {
		return contat;
	}

	public void setContat(String contat) {
		this.contat = contat;
	}
}
