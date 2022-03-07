package exceptionM;

import java.io.File;

public class Ex_10 {
	public static void main(String[] args) {
		try {
			File f = createFile("");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 다시 입력해주세요");
			e.printStackTrace();
			// main이 createFile호출,
			// createFile에서 예외 발생
		}
	}
	
	static File createFile(String fileName) throws Exception {
		if(fileName == null || fileName == "") {
			throw new Exception("파일 이름이 유효하지 않습니다.");
		}
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}
}
