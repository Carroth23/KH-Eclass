import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(22000);
		Socket sock = server.accept();

		System.out.println(sock.getInetAddress() + " 로 부터 연결되었습니다.");

		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

		String msg = dis.readUTF();
		
		dos.writeUTF("Good Morning");
		dos.flush();
	}
}
