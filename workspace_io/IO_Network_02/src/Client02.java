import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client02 {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("220.117.126.242", 22000);
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		dos.writeUTF("딸기");
		dos.flush();
		
		String msg = dis.readUTF();
		System.out.println("서버로부터의 메세지 : " + msg);
		
		// 127.0.0.1
	}
}
