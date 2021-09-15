import java.util.Scanner;

public class nakseo {
   // Bubble sort method
   // 범용성있는 코드를 짜도록 하자!
   public static void bubbleSort(int arr[]) {

      for (int i = 0; i < arr.length -1; i++) {

         for (int j = 0; j < arr.length -1;j++) {
            if (arr[j] > arr[j+1]) {
               int temp = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = temp;
            }
         }
      }
   }

   // Main
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("===== 버블정렬 메소드 =====");
      int a;
      while (true) {
         try {
            System.out.print("배열의 크기를 입력해주세요 : ");
            a = Integer.parseInt(sc.nextLine());
            break;
         } catch (Exception e) {
            System.out.println("배열의 크기를 숫자로 입력해주세요.");
         }
      }

      int [] arr = new int [a]; // 크기 지정해주면 중괄호는 필요 없음!

      while (true) {

         for (int i = 0; i < arr.length; i++) {
            try {
               System.out.println("숫자를 입력하세요 : ");
               arr[i] = Integer.parseInt(sc.nextLine());
            } 
            catch (Exception e) {
               System.out.println("숫자만 입력해주세요");
               i--; // i 숫자가 계속 올라가고 있었다는게 문제?
            }
         }break;
      }

      System.out.print("정렬 전 : ");
      for (int i = 0; i < arr.length; i++) {

         System.out.print(arr[i]+ " ");
      }

      bubbleSort(arr);

      System.out.print("\n정렬 후 : ");
      for (int i = 0; i < arr.length; i++) {

         System.out.print(arr[i]+ " ");
      }
   }
}