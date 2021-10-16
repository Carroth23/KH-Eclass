import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client01 {
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("127.0.0.1", 22000);

		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		DataInputStream dis = new DataInputStream(client.getInputStream());

		dos.writeUTF(JOptionPane.showInputDialog("명령어를 입력하세요.")); // String타입을 UTF타입으로 인코딩한 메세지를 택배차량에 담겠다.
		dos.flush();
		
//		dis.readInt()이건 int
		String msg = dis.readUTF();
		System.out.println("서버로부터의 메세지 : " + msg);
	}

}

// 내꺼 175.123.204.32
// 승훈 61.72.43.242
// 병주 175.211.64.11
// 혜주 220.117.126.242
// 윤수 124.58.130.169
