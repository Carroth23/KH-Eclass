import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Adfsf {
	
	public static String randomNumberGenerator() {
		int[] numbers = new int[6];
		for(int i = 0; i < 6; i++) {
			numbers[i] = (int)(Math.random()*45)+1;
		}
		String result = Arrays.toString(numbers);
		return result;
	}
	public static void main(String[] args) throws IOException {
		//소켓 : 네트워크 프로그램에서 통신으로 수행하기 위한 논리적 단말기 
		
		ServerSocket server = new ServerSocket(22000);
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress()+ " 로 부터 연결되었습니다.");
		
		
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		
		String msg = dis.readUTF();
		System.out.println("클라이언트가 보낸 메세지: "+ msg);
		
		if(msg.equals("time")) {
			String dateString = sdf.format(System.currentTimeMillis());
			dos.writeUTF(dateString);
			dos.flush();
		}else if(msg.equals("lotto")) {
			
			dos.writeUTF(randomNumberGenerator());
			dos.flush();
		}
		}
	
		
	}