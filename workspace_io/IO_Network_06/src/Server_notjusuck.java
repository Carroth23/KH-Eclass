import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_notjusuck {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(22000);
		System.out.println("연결을 대기 중 입니다.");
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 연걸.");
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		File target = new File("C:\\Users\\Carroth23\\Pictures\\짤들\\부리.png");
		
		FileInputStream fis = new FileInputStream(target); // HDD에서 RAM으로 (input)꺼내오기위해 스트림 개방.
		DataInputStream dis = new DataInputStream(fis); // FileInputStream 업그레이드
		byte[] fileContents = new byte[(int)target.length()]; // 파일은 바이트들의 묶음으로 다룬다.
		// 배열의 사이즈는 int를 벗어날 수 없다.
		dis.readFully(fileContents);
		
		dos.writeInt(fileContents.length); // 사이즈 먼저 전달.
		dos.write(fileContents);
		dos.flush();
	}
}
