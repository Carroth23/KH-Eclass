package comparatorM;

import java.util.Arrays;

public class comparEx {
	public static void main(String[] args) {
		String[] strarr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strarr); // String Comparable에 의해 정렬
		System.out.println(Arrays.toString(strarr));
	}
}
