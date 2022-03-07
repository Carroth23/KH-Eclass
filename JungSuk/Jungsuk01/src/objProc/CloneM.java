package objProc;

public class CloneM {
	public static void main(String[] args) {
		String q = " 가나다.,txt.,png ";
		System.out.println(q.charAt(1));
		System.out.println(q.contains("나다"));
		System.out.println(q.endsWith(".txt"));
		System.out.println(q.replace("나다", "너아니다"));
		String[] w = q.split(",");
		System.out.println(w[0]);
		System.out.println(q.trim());
		System.out.println(String.join("-", w).trim());
		
		int i = 100;
		String str = String.valueOf(i);
//		System.out.println(str * 10); 문자열
		int i2 = Integer.valueOf(str);
		System.out.println(i2 * 10);
		
		double e = 101.2;
		System.out.println(Math.ceil(e));
		System.out.println(Math.floor(e));
		System.out.println(Math.max(14, e));
	}
}

