package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.GuestbookDAO;
import dao.LoginDAO;
import dto.GuestbookDTO;
import dto.LoginDTO;
import utils.EncryptUtils;

public class Server01 {
	public static void main(String[] args) throws Exception {
		LoginDAO ldao = LoginDAO.getInstance();
		GuestbookDAO gdao = GuestbookDAO.getInstance();
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

					LoginDTO ldto = ldao.isIdPwExist(id, pw); // 로그인 실패 - null, 성공 - 정보가 담긴 dto

					if (ldto != null) {
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
					boolean isIdExist = ldao.isIdExist(id);
					dos.writeBoolean(isIdExist);
					dos.flush();

					if (isIdExist) {
						continue;
					}

					LoginDTO dto = new LoginDTO(id, pw, name, null);
					try {
						int result = ldao.signUp(dto);
						dos.writeInt(result);
					} catch (Exception e) {
						e.printStackTrace();
						dos.writeInt(-1);
					}
					dos.flush();
				} else if (menu.equals("write")) {
					String writer = dis.readUTF();
					String message = dis.readUTF();

					int result = gdao.insert(writer, message);
					dos.writeInt(result);
					dos.flush();
				} else if (menu.equals("list")) {
					List<GuestbookDTO> list = gdao.selectAll();

					dos.writeInt(list.size());
					dos.flush();

					for (GuestbookDTO gdto : list) {
						dos.writeInt(gdto.getSeq());
						dos.writeUTF(gdto.getWriter());
						dos.writeUTF(gdto.getMessage());
						dos.writeUTF(gdto.getFormatDate());
						dos.flush();
					}
				} else if (menu.equals("delete")) {
					int seq = dis.readInt();
					int result = gdao.delete(seq);

					if (result > 0) {
						dos.writeInt(result);
					} else {
						dos.writeInt(-1);
					}

				} else if (menu.equals("search")) {
					String keyword = dis.readUTF();

					List<GuestbookDTO> list = gdao.search(keyword);

					dos.writeInt(list.size());
					dos.flush();

					for (GuestbookDTO gdto : list) {
						dos.writeInt(gdto.getSeq());
						dos.writeUTF(gdto.getWriter());
						dos.writeUTF(gdto.getMessage());
						dos.writeUTF(gdto.getFormatDate());
						dos.flush();
					}

				}
			}
		}

	}
}
