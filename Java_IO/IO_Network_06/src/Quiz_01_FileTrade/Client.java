package Quiz_01_FileTrade;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {

		try (Scanner sc = new Scanner(System.in);
			Socket client = new Socket("127.0.0.1", 22000);
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream())
			) {

			// 2. 서버가 보내오는 파일 명단을 받아서 화면에 출력한다.
			int fileCount = dis.readInt(); // 파일의 갯수 회신
			for (int i = 0; i < fileCount; i++) { // 회신받은 갯수만큼 반복
				System.out.println(dis.readUTF()); // 파일명 출력
			}

			// 3. 서버가 보내온 명단 중에, 한개 파일을 선택하여 이름을 입력하고 입력한 이름을 서버에 전송
			System.out.println("다운 받을 파일 이름 : ");
			String fileName = sc.nextLine();
			dos.writeUTF(fileName);
			dos.flush();

			// 7. 서버에서 전달되어오는 파일 내용을 받아서 RAM에 적재한다.
			int fileSize = dis.readInt(); // 서버에서 보낼 파일의 바이트 배열 크기
			byte[] fileContents = new byte[fileSize]; // 받을 바이트 배열 준비
			dis.readFully(fileContents);

			// 8. 3번에서 선택한 파일 이흠으로 클라이언트 경로에 저장한다.
			File downloadFile = new File("C:/WebD/dest/" + fileName); // 다운받을 파일의 이름.
			try (FileOutputStream fos = new FileOutputStream(downloadFile); // RAM에서 HDD로 보낼 다리
				DataOutputStream fileDos = new DataOutputStream(fos)
				) {
				fileDos.write(fileContents);
				fileDos.flush();
			}
		}

	}
}
