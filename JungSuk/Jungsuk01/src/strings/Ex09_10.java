package strings;

public class Ex09_10 {
	public static void main(String[] args) {
		// 불편하지만 조금 빠름
		int iVal = 100;
		String strVal = String.valueOf(iVal);
		
		// 편하지만 조금 느림
		double dVal = 200.0;
		String strVal2 = dVal + "";
		
		double sum = Integer.parseInt("+" + strVal) + Double.valueOf(strVal2);
								// join StringBuffer을 사용해서 결합하기때문에 좀더 빠름
		System.out.println(String.join("", strVal, "+", strVal2, "=") + sum);
	}
}
