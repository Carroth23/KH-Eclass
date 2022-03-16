import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Server02_Toy {

	public static String lotto() {
		// 로또값
		int[] lotto = new int[45];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		for (int i = 0; i < lotto.length * 10; i++) {
			int x = (int) (Math.random() * 45);
			int y = (int) (Math.random() * 45);

			int tmp = lotto[x];
			lotto[x] = lotto[y];
			lotto[y] = tmp;
		}
		String result = "";
		for (int i = 0; i < 6; i++) {
			result += lotto[i] + " ";
		}
		return result;
	}

	public static String time() {
		// 시간값
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		long timestamp = System.currentTimeMillis();
		return sdf.format(timestamp);
	}

	public static void main(String[] args) throws Exception /* 원래 메인에선 throws하면안됨 */ {

		ServerSocket server = new ServerSocket(22000);

		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 연결되었습니다.");

		DataInputStream dis = new DataInputStream(sock.getInputStream()); // 데이터 받기
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream()); // 데이터 내보내기

		String msg = dis.readUTF();

		if (msg.equals("lotto")) {
			dos.writeUTF("오늘의 로또 번호 : " + lotto());
			dos.flush();
		} else if (msg.equals("time")) {
//			dos.writeUTF(JOptionPane.showInputDialog(time, null)); 얘를 쓰면 입력창이 떠버림
			dos.writeUTF("현재 시간값 : " + time());
			dos.flush();
			// 175.123.204.32
		}
	}
}
