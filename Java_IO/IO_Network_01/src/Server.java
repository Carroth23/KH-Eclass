import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws Exception /* 원래 메인에선 throws하면안됨 */ {

		// 소켓 : 네트워크프로그램에서 통신을 수행하기 위한 논리적 단말기
		// 서버는 서버소켓(소켓공장)을 가지고 있어야 한다.
		// 내꺼 175.123.204.32
		// 공유기 사용자가 서버를 하려면 포트포워딩이 필요.

//		공유기 설정에서 내, 외부포트에 걍 22000넣으면 됨 내부ip는 노트북 ip
		ServerSocket server = new ServerSocket(22000); // 서버소켓 인스턴스 생성.

		Socket sock = server.accept(); // 서버를 열고 클라이언트가 오는것을 대기중 (연결되면 Socket로 받음)
		System.out.println(sock.getInetAddress() + " 로 부터 연결되었습니다."); // 접속한 사람의 IP알려줌

		// Stream : 데이터를 주고받는 통로.
		InputStream is = sock.getInputStream(); // 데이터를 받아들이는 불편한 다리
		DataInputStream dis = new DataInputStream(is); // 불편한 다리 보강공사

		OutputStream os = sock.getOutputStream(); // 데이터를 내보내는 불편한 다리
		DataOutputStream dos = new DataOutputStream(os); // 불편한 다리 보강공사

		while (true) { // 주고받고주고받고
			String msg = dis.readUTF(); // 클라이언트로부터 온 메세지를 String값으로 받는것.
//			System.out.println("클라이언트가 보낸 메세지 : " + msg); 그래픽창 띄울라면 얘 지워야됨
			JOptionPane.showMessageDialog(null, msg); // 연속적으로나오지는 않지만 그래픽창으로 띄움

			dos.writeUTF(JOptionPane.showInputDialog("메세지를 입력하세요.")); // String타입을 UTF타입으로 인코딩한 메세지를 택배차량에 담겠다.
			dos.flush(); // 택배차량 출발
			// 프로토콜 : 통신규약(데이터를 주고받는 순서? 같은걸 서로 맞춰주는걸 규약이라고 함)
		}
	}
}
