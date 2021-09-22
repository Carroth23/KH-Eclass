
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
		
	}

}
