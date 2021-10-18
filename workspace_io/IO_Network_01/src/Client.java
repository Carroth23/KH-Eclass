import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("220.117.126.242", 22000);

		OutputStream os = client.getOutputStream(); // 데이터를 내보내는 불편한 다리
		DataOutputStream dos = new DataOutputStream(os); // 불편한 다리 보강공사

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		while (true) { // 주고받고 주고받고
			dos.writeUTF(JOptionPane.showInputDialog("메세지를 입력하세요.")); // String타입을 UTF타입으로 인코딩한 메세지를 택배차량에 담겠다.
			// JOptionPane는 그래픽으로 입력창을 띄움
			dos.flush(); // 택배차량 출발

			String msg = dis.readUTF();
			System.out.println("서버로부터의 메세지 : " + msg);
		}
	}

}

// 내꺼 175.123.204.32
// 승훈 61.72.43.242
// 병주 175.211.64.11
// 혜주 220.117.126.242
// 윤수 124.58.130.169
// 본인꺼에 접속하는 아이피 127.0.0.1