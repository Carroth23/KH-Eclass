import java.util.*;

public class Quiz_01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		System.out.println("***ATM �ùķ�����***");
		
		while(true) {
			System.out.println("****************");
			System.out.println("1. �ܾ���ȸ");
			System.out.println("2. �Ա��ϱ�");
			System.out.println("3. ����ϱ�");
			System.out.println("4. �����ϱ�");
			System.out.println(">> ");
			
			int num = 0;
			while (true) {
				try {
					num = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("�޴� ���ڸ� Ȯ�����ּ���.");
				}
			}
			
			switch (num) {
			case 1:
				System.out.println("���� �������� �ܾ��� " + sum + "�� �Դϴ�.");
				break;
			case 2:
				System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
				
				int put = 0;
				while (true) {
					try {
						put = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("���ڸ� �Է��� �ּ���.");
					}
				}
				sum += put;
				System.out.println(put + "���� �Ա� �Ǿ����ϴ�.");
				break;
			case 3:
				System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
				
				int out = 0;
				while (true) {
					try {
						out = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("���ڸ� �Է��� �ּ���.");
					}
				}
				if (sum >= out) {
					sum -= out;
					System.out.println(out + "���� ��ݵǾ����ϴ�.");
				} else {
					System.out.println("�ܾ��� �����մϴ�. �ܾ��� Ȯ�����ֽʽÿ�.");
				}
				break;
			case 4:
				System.out.println("���α׷��� �����ϰڽ��ϴ�.");
//				break; // Ȥ�� �극��ũ�� while���� �̸��� �༭ while�� �������� �ִ�.
				 System.exit(0); // ���ε� ������ѹ����� �ִ�.
			default:
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���");
			}
//			if (num == 4) // �̰͵� ������ �� ���
//				break;
		}
		
	}
}
