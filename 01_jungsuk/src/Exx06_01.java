
<<<<<<< HEAD
public class Exx06_01 {

	public static int[] shuffle(int[] arr) {
		int[] tmp = {0};
		int random = (int)(Math.random() * 10);
		for (int i = 0; i < arr.length; i++) {
			tmp[0] = arr[i];
			arr[i] = arr[random];
			arr[random] = tmp[0];
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		
=======
public class Exx06_01{
	
	public static void main(String[] args) {
		
		int sum = 0;
		float average = 0f;
		
		int[] score = {100, 88, 100, 100, 90};
		
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		
		average = sum / (float)score.length;
		
		System.out.println(sum);
		System.out.println(average);
>>>>>>> 6b090a6ee49a8911b2f40ab6599da09cbcd75395
	}
}