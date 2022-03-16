package streamM;

import java.util.Comparator;
import java.util.stream.Stream;

public class 스트림03중간연산_comparable {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 1, 300),
				new Student("소자바", 2, 150),
				new Student("나자바", 3, 300)
				);
				
		studentStream.sorted(Comparator.comparing(Student::getBan) // 반별정렬
				.thenComparing(Comparator.naturalOrder())) // 기본정렬
				.forEach(System.out::println);
	}
}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int ban, int totalScore) {
		super();
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("%s, %d, %d", name, ban, totalScore);
	}
	
	// 총점 내림차순 정렬
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}