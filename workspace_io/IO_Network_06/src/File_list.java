import java.io.File;

public class File_list {
	public static void main(String[] args) {
		
		File f = new File("C:\\WebD\\libs");
		System.out.println(f.isFile()); // ↑너 파일이니?
		System.out.println(f.isDirectory());
		
		File[] list = f.listFiles(); // 폴더안의 모든 파일들은 파일 객체로 만든 후 배열로 리턴
		for(File tmp : list) {
			System.out.println(tmp.getName() + " : " + tmp.length());
		}
	}
}
