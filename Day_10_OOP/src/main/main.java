package main;
import java.util.Scanner;

import electronic.Book;
import electronic.Monitor;
import electronic.Student;
import electronic.Tv;

public class main {

	public static void main(String[] args) throws Exception {

//		new 힙에다 만들겠다 새로운걸 만들겠다
		Monitor m; // 모니터 클래스가 참조변수형처럼 되어버림 이상태는 아직 모니터가 메모리에 없다
//		Monitor m = new Monitor(); 이렇게 작성해야 메모리에 올라옴
//		new Monitor(); 이렇게 작성해도 메모리에 올라옴
		
		Scanner sc = new Scanner(System.in);
		Monitor m1 = new Monitor();
		Monitor m2 = new Monitor();
		
//		m. // . 을 참조연산자라고 부른다.(주소로 찾아가라)
		
//		Robot r = new Robot();
//		for (int i = 0; i < 100; i++) {
//			r.mouseMove(1000 + i, 500);
//			Thread.sleep(i);
//		}
		
		Tv lg = new Tv();
		lg.setChannel(10);
		System.out.println(lg.getChannel());
		
//		Book bo = new Book(/*생성자 콜이기 때문에 여기에 파라미터도 입력 가능*/ 1001, "연금술사", 14000);
//		bo.setId(1001);
//		bo.setPrice(14000);
//		bo.setTitle("로미오와줄리엣");
		
		
//		Book bo2 = new Book(1002, "아프면 병원가라", 150); // 생성자를 통한 값 세팅
//		bo2.setId(1002);
//		bo2.setPrice(15000);
//		bo2.setTitle("연금술사");
		
//		Book bo3 = new Book();
//		bo3.setId(1003);
//		bo3.setPrice(20000);
//		bo3.setTitle("해커스토익");
//		
//		System.out.println(bo.getId());
//		System.out.println(bo.getTitle());
//		System.out.println(bo.getPrice());
//		System.out.println(bo2.getId());
//		System.out.println(bo2.getTitle());
//		System.out.println(bo2.getPrice());
//		System.out.println(bo3.getId());
//		System.out.println(bo3.getTitle());
//		System.out.println(bo3.getPrice());
//		
//		System.out.println("책 3권의 전체 가격은 " + (bo.getPrice() + bo2.getPrice() + bo3.getPrice()));
		
		Student std1 = new Student(1001, "Jin", 90, 60, 80);
		System.out.println(std1.getName());
		System.out.println(std1.getId());
		System.out.println(std1.getMath());
		System.out.println(std1.getEng());
		System.out.println(std1.getKor());
//		std1.setId(1001);
//		std1.setName("Jack");
//		std1.setKor(90);
//		std1.setEng(60);
//		std1.setMath(80);
		
		Student std2 = new Student();
		System.out.println(std2.getId());
//		std2.setId(1002);
//		std2.setName("Jane");
//		std2.setKor(80);
//		std2.setEng(90);
//		std2.setMath(70);
		
		
		
		
		
		
//		System.out.println("Jack 학생의 총점 : " + (std1.getKor() + std1.getEng() + std1.getMath()));
//		System.out.println("Jack 학생의 총점 : " + std1.getSum());
//		System.out.printf("Jack 학생의 평균 : %.2f%n%n", std1.getDiv());
//		System.out.println("Jane 학생의 총점 : " + std2.getSum());
//		System.out.printf("Jane 학생의 평균 : %.2f%n", std2.getDiv());
	}

}
