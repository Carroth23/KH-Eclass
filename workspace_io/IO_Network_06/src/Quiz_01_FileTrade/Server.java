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

			try (Socket sock = server.accept(); // 연결 대기
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				DataInputStream dis = new DataInputStream(sock.getInputStream())
				) {

				System.out.println(sock.getInetAddress() + " 로 부터 연결");

				// 1. 전송할 수 있는 파일 목록을 생성해서 클라이언트에게 전달한다.
				File root = new File("C:/WebD/libs"); // 메타데이터를 저장(대상에 대한 정보)
				File[] files = root.listFiles(); // 폴더안의 파일들을 배열로 리턴
				dos.writeInt(files.length); // 파일이 몇개인지 서버로 전송.
				for (File f : files) {
					dos.writeUTF(f.getName()); // 파일명 계속 전송.
					dos.flush();
				}

				// 4. 클라이언트가 입력해서 전송한 파일이름을 화면에 출력한다.
				String target = dis.readUTF();
				System.out.println("클라이언트가 선택한 파일 이름 : " + target);

				File targetFile = new File(root.getPath() + "/" + target); // 파일 인스턴스 생성
				try (FileInputStream fis = new FileInputStream(targetFile); // RAM에 올릴 다리를 놓고
						DataInputStream fileDis = new DataInputStream(fis); // 그 다리를 강화
				) {

					// 5. 클라이언트가 보낸 파일을 RAM으로 로딩
					byte[] fileContents = new byte[(int) targetFile.length()]; // 해당 파일을 담을? 배열 생성
					fileDis.readFully(fileContents); // (fileContents에다가 파일의 내용을 저장해줘)

					// 6. 로딩된 파일의 내용을 클라이언트로 전송
					dos.writeInt(fileContents.length); // Client에게 파일을 받을 byte배열의 크기를 미리 알려줌.
					dos.write(fileContents);
					dos.flush();
				}

			} catch (Exception e) {
				System.out.println("접속 에러가 발생했습니다.");
			}
		}
	}
}
