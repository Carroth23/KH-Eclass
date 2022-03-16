package quiz_Login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Q01_Server {
	public static void main(String[] args) throws Exception {
		Q01DAO dao = new Q01DAO();
		System.out.println("연결을 대기중입니다..");
		try (ServerSocket server = new ServerSocket(22000);
				Socket sock = server.accept();
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());) {

			System.out.println(sock.getInetAddress() + "로 부터 연결되었습니다.");

			while (true) {
				String menu = dis.readUTF();

				if (menu.equals("1")) {
					// 로그인
					String id = dis.readUTF();
					String pw = EncryptUtils.getSHA512(dis.readUTF());
					
					Q01DTO dto = dao.isIdPwExist(id, pw); // 로그인 실패 - null, 성공 - 정보가 담긴 dto
					
					if (dto != null) {
						dos.writeBoolean(true);
					} else {
						dos.writeBoolean(false);
						continue;
					}
					dos.flush();
					
				} else if (menu.equals("2")) {
					// 회원가입
					String id = dis.readUTF();
					String pw = EncryptUtils.getSHA512(dis.readUTF());
					String name = dis.readUTF();

					// 중복검사
					boolean isIdExist = dao.isIdExist(id);
					dos.writeBoolean(isIdExist);
					dos.flush();
					
					if (isIdExist) {continue;}
					
					Q01DTO dto = new Q01DTO(id, pw, name, null);
					try {
						int result = dao.signUp(dto);
						dos.writeInt(result);
					} catch (Exception e) {
						e.printStackTrace();
						dos.writeInt(-1);
					}
					dos.flush();
				}
			}
		}

	}
}
