
public class Ex01 {
	public static void main(String[] args) {
		int a = 6;
		int b = 6;
		int cnt = 0;
		for(int i = 1; i <= a; i++) {
			for(int j = 1; j <= b; j++) {
				if(j + i == 6) {
					cnt++;
					System.out.println(i + "+" + j + "=" + (i+j));
				}
			}
		}
		System.out.println("총 " + cnt + "회");
	}
}
