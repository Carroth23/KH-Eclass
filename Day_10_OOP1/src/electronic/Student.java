package electronic;

public class Student {

	// 학번 숫자 id
	// 학생 이름 name
	// 국어 점수
	// 영어 점수
	// 수학 점수
	
//	1001, Jack, 90 60 80
//	1002, Jane, 80 90 70
	
	private int id = 100;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	
	public Student() {}
	public Student(int id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getKor() {
		return kor;
	}
//	public void setKor(int kor) {
//		this.kor = kor;
//	}
	public int getEng() {
		return eng;
	}
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
	public int getMath() {
		return math;
	}
//	public void setMath(int math) {
//		this.math = math;
//	}
//	
//	public int getSum() {
//		return this.eng + math + kor;
//	}
//	public double getDiv() {
//		return getSum() / 3.0;
//	}
}
