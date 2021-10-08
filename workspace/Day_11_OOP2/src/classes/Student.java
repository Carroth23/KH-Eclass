package classes;

public class Student {

	private int id;
	private String name;
	private int eng;
	private int kor;
	private int math;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public Student() {}
	public Student(int id, String name, int eng, int kor, int math) {
		super();
		this.id = id;
		this.name = name;
		this.eng = eng;
		this.kor = kor;
		this.math = math;
	}

	public int getSum() {
		return this.eng + this.kor + this.math;
	}

	public double getAvg() {
		return getSum() / 3.0;
	}

}
