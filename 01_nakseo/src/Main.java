import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Silver sil = new Silver(); // �ν��Ͻ�ȭ
		int id = 1001;
		int index = 0;
		Silver[] sils = new Silver[10];

		
		for (int i = 0; i < 12; i++) {
			System.out.println(sils[i]);
		}
		while (true) {
			System.out.println("== ȸ�� ���� �ý��� ==");
			System.out.println("1. �ű� ȸ�� ���");
			System.out.println("2. ȸ�� ��� ���");
			System.out.println("3. �ý��� ����.");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.println("�ű� ȸ�� ��� â�Դϴ�.");
				System.out.print("�ű� ȸ���� �̸� : _");
				String name = sc.nextLine();
				System.out.print("ȸ���� ����Ʈ : _");
				int point = Integer.parseInt(sc.nextLine());
				
				sils[index].setId(id);
				sils[index].setName(name);
				sils[index].setPoint(point);
				id++;
				index++;
				break;
			case 2:
				for (int i = 0; i < index; i++) {
					System.out.println(sils[index].getId() + "\t" + sils[index].getName() + "\t"
							+ sils[index].getPoint() + "\t" + sils[index].getBonus());
				}
				break;
			case 3:
				System.exit(0);
			}

		}

	}
}