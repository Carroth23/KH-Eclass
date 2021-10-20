import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(22000);
		System.out.println("연결을 대기 중 입니다.");
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 연걸.");
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		// 파일 전송 1. HDD에 있는 파일을 RAM으로 꺼내와서
		// 2. 클라이언트 RAM으로 전송후, 클라이언트의 HDD로 저장
		// Input, Output의 기준점은 항상 RAM이다. RAM으로 들어오던지, RAM에서 내보내든지.
		
//		1. HDD에 있는 파일을 RAM으로 꺼내와서
		File target = new File("C:\\Users\\Carroth23\\Pictures\\짤들\\부리.png"); // 파일이 들어 있는게 아니라 정보가 들어있음.

//		System.out.println("파일 존재 : " + target.exists());
//		System.out.println("파일 사이즈 : " + target.length()); // long값 리턴
//		System.out.println("파일 경로 : " + target.getAbsolutePath());
//		System.out.println("파일 이름 : " + target.getName());
		FileInputStream fis = new FileInputStream(target); // HDD에서 RAM으로 (input)꺼내오기위해 스트림 개방.
		DataInputStream dis = new DataInputStream(fis); // FileInputStream 업그레이드
		byte[] fileContents = new byte[(int)target.length()]; // 파일은 바이트들의 묶음으로 다룬다.
		// 배열의 사이즈는 int를 벗어날 수 없다.
		dis.readFully(fileContents); // readFully는 파일의 내용을 fileContents로가져오라는 명령.
//		System.out.println(fileContents[1]); // 내용 확인
		
		
//		2. Server RAM에 있는 파일 내용을 클라이언트 RAM으로 전달.
		dos.writeInt(fileContents.length); // 사이즈 먼저 전달.
		dos.write(fileContents);
		dos.flush();
		
		
	}
}
