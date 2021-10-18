import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Server01 {
	public static void main(String[] args) throws Exception /* 원래 메인에선 throws하면안됨 */ {

		ServerSocket server = new ServerSocket(22000);

		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 연결되었습니다.");

		DataInputStream dis = new DataInputStream(sock.getInputStream()); // 데이터 받기
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream()); // 데이터 내보내기

		// 현재 시간값
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		long timestamp = System.currentTimeMillis();
		String time = sdf.format(timestamp);

		String msg = dis.readUTF();
		if (msg.equals("time")) {
//			dos.writeUTF(JOptionPane.showInputDialog(time, null)); 얘를 쓰면 입력창이 떠버림
			dos.writeUTF("현재 시간값 : " + time);
			dos.flush();
		} else {
			dos.writeUTF("time을 알고싶으면 time을");
		}
		
	}
}
