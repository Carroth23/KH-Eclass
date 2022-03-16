import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("175.211.64.11", 23000);
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
//		2. Server RAM에 있는 파일 내용을 클라이언트 RAM으로 도착.
		int size = dis.readInt();
		byte[] fileContents = new byte[size];
		dis.readFully(fileContents);
		
		File f = new File("C:/WebD/dest/pich.jpg");
		FileOutputStream fos = new FileOutputStream(f); // 클리어인트 RAM에 있는 파일을 클라이언트 HDD로 내보냄.
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.write(fileContents);
		dos.flush();
		dos.close();
		
		// 127.0.0.1
	}	// 192.168.219.101 22000 윤수
		// 175.211.64.11 병주
		// 220.117.126.242 혜주
		// 124.58.130.169 승훈
}
