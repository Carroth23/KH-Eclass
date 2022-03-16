import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(22000);
		Socket sock = server.accept();

		System.out.println(sock.getInetAddress() + " 로 부터 연결되었습니다.");

		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		String msg = dis.readUTF();
		
		if (msg.equals("사과")) {
			dos.writeUTF(msg + "는 영어로 : Apple");
		} else if (msg.equals("포도")) {
			dos.writeUTF(msg + "는 영어로 : Grape");
		} else if (msg.equals("딸기")) {
			dos.writeUTF(msg + "는 영어로 : Strawberry");
		} else {
			System.out.println("none");
		}
		
		dos.flush();
	}
}
