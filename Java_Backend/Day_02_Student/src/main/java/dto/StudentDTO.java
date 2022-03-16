package dto;

public class StudentDTO {
	private int seq;
	private String name;
	private int kor;
	private int eng;

	public StudentDTO() {

	}

	public StudentDTO(int seq, String name, int kor, int eng) {
		super();
		this.seq = seq;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
}