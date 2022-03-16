package quiz_Login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Q01_Client {
	public static void main(String[] args) throws IOException {

		try (Scanner sc = new Scanner(System.in);
				Socket client = new Socket("127.0.0.1", 22000);
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				DataInputStream dis = new DataInputStream(client.getInputStream());) {
			while (true) {

				System.out.println("== 관리 시스템 ==");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 종료");
				System.out.print(">>");
				String menu = sc.nextLine();
				dos.writeUTF(menu);

				if (menu.equals("1")) {

					System.out.println("ID 입력 : ");
					String id = sc.nextLine();

					System.out.println("PW 입력 : ");
					String pw = sc.nextLine();

					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					
					boolean loginResult = dis.readBoolean();
					if (loginResult) {
						System.out.println("로그인에 성공했습니다.");
					} else {
						System.out.println("아이디나 패스워드를 다시 확인해주세요.");
					}
					
				} else if (menu.equals("2")) {

					System.out.println("사용할 ID를 입력하세요 : ");
					String id = sc.nextLine();

					System.out.println("사용할 PW를 입력하세요 : ");
					String pw = sc.nextLine();

					System.out.println("이름을 입력하세요 : ");
					String name = sc.nextLine();

					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.writeUTF(name);
					dos.flush();

					// 중복검사 확인
					boolean isIdExist = dis.readBoolean();
					if (isIdExist) {
						System.out.println("이미 사용중인 ID 입니다.");
						continue;
					}

					int result = dis.readInt();
					if (result > 0) {
						System.out.println("가입 성공!");
					} else {
						System.out.println("알 수 없는 오류로 가입에 실패했습니다.");
					}

				} else if (menu.equals("3")) {

					System.out.println("시스템을 종료합니다.");
					System.exit(0);

				} else {
					System.out.println("메뉴를 다시 확인해주세요.");
				}
				// 127.0.0.1
			}
		}
	}
}
