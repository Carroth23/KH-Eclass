package main;
import java.util.Scanner;

import electronic.Calc;
import electronic.Monitor;
import electronic.Student;
import electronic.Tv;

public class main {

	public static void main(String[] args) throws Exception {

//		new ������ ����ڴ� ���ο�� ����ڴ�
		Monitor m; // ����� Ŭ������ ����������ó�� �Ǿ���� �̻��´� ���� ����Ͱ� �޸𸮿� ����
//		Monitor m = new Monitor(); �̷��� �ۼ��ؾ� �޸𸮿� �ö��
//		new Monitor(); �̷��� �ۼ��ص� �޸𸮿� �ö��
		
		Scanner sc = new Scanner(System.in);
		Monitor m1 = new Monitor();
		Monitor m2 = new Monitor();
		
//		m. // . �� ���������ڶ�� �θ���.(�ּҷ� ã�ư���)
		
//		Robot r = new Robot();
//		for (int i = 0; i < 100; i++) {
//			r.mouseMove(1000 + i, 500);
//			Thread.sleep(i);
//		}
		
		Tv lg = new Tv();
		lg.setChannel(10);
		System.out.println(lg.getChannel());
		
//		Book bo = new Book(/*������ ���̱� ������ ���⿡ �Ķ���͵� �Է� ����*/ 1001, "���ݼ���", 14000);
//		bo.setId(1001);
//		bo.setPrice(14000);
//		bo.setTitle("�ι̿����ٸ���");
		
		
//		Book bo2 = new Book(1002, "������ ��������", 150); // �����ڸ� ���� �� ����
//		bo2.setId(1002);
//		bo2.setPrice(15000);
//		bo2.setTitle("���ݼ���");
		
//		Book bo3 = new Book();
//		bo3.setId(1003);
//		bo3.setPrice(20000);
//		bo3.setTitle("��Ŀ������");
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
//		System.out.println("å 3���� ��ü ������ " + (bo.getPrice() + bo2.getPrice() + bo3.getPrice()));
		
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
		
		Calc c = new Calc();
		
		System.out.println(c.plus(10, 5)); // 15
		System.out.println(Calc.minus(10, 5)); // 5
		
		
		
		
//		System.out.println("Jack �л��� ���� : " + (std1.getKor() + std1.getEng() + std1.getMath()));
//		System.out.println("Jack �л��� ���� : " + std1.getSum());
//		System.out.printf("Jack �л��� ��� : %.2f%n%n", std1.getDiv());
//		System.out.println("Jane �л��� ���� : " + std2.getSum());
//		System.out.printf("Jane �л��� ��� : %.2f%n", std2.getDiv());
	}

}
