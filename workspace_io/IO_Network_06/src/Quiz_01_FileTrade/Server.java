package Quiz_01_FileTrade;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		System.out.println("연결 대기중..");
		ServerSocket server = new ServerSocket(22000); // 얘도 close해줘야되긴 함

		while (true) { // 여기에 while주면 한명이 들어와서 받고 나가고 다른사람이 들어와서 받고 할 수 있음.

			try (Socket sock = server.accept();
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				DataInputStream dis = new DataInputStream(sock.getInputStream())
				) {

				System.out.println(sock.getInetAddress() + " 로 부터 연결");

				File root = new File("C:/WebD/libs");
				File[] files = root.listFiles(); // 폴더안의 파일들을 배열로 리턴

				// 1. 전송할 수 있는 파일 목록을 생성해서 클라이언트에게 전달한다.
				dos.writeInt(files.length); // 파일이 몇개인지 서버로 전송.
				for (File f : files) {
					dos.writeUTF(f.getName()); // 파일명 계속 전송.
					dos.flush();
				}

				// 4. 클라이언트가 입력해서 전송한 파일이름을 화면에 출력한다.
				String target = dis.readUTF();
				System.out.println("클라이언트가 선택한 파일 이름 : " + target);

				File targetFile = new File(root.getPath() + "/" + target); // 파일 인스턴스 생성
				try (FileInputStream fis = new FileInputStream(targetFile); // 전송할 다리를 놓고
						DataInputStream fileDis = new DataInputStream(fis); // 그 다리를 강화
				) {

					// 5. 클라이언트가 보낸 파일을 RAM으로 로딩
					byte[] fileContents = new byte[(int) targetFile.length()];
					fileDis.readFully(fileContents);

					// 6. 로딩된 파일의 내용을 클라이언트로 전송
					dos.writeInt(fileContents.length);
					dos.write(fileContents);
					dos.flush();
				}

			} catch (Exception e) {
				System.out.println("접속자가 에러내고 튕겼습니다.");
			}
		}
	}
}
