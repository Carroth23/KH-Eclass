
public class Quiz_03_Random {

	public static void main(String[] args) {

		System.out.println("0 ~ 9 까지의 랜덤 수 : " + (int)(Math.random() * 10));
		System.out.println("1 ~ 10 까지의 랜덤 수 : " + ((int)(Math.random() * 10) + 1));
		System.out.println("20 ~ 35 까지의 랜덤 수 : " + (int)(Math.random() * (35 - 20 +1) + 20));
		System.out.println("0 또는 1 : " + (int)(Math.random() * 2));
		
	}

}
