import java.util.Scanner;

public class nakseo {
   // Bubble sort method
   // ���뼺�ִ� �ڵ带 ¥���� ����!
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
      System.out.println("===== �������� �޼ҵ� =====");
      int a;
      while (true) {
         try {
            System.out.print("�迭�� ũ�⸦ �Է����ּ��� : ");
            a = Integer.parseInt(sc.nextLine());
            break;
         } catch (Exception e) {
            System.out.println("�迭�� ũ�⸦ ���ڷ� �Է����ּ���.");
         }
      }

      int [] arr = new int [a]; // ũ�� �������ָ� �߰�ȣ�� �ʿ� ����!

      while (true) {

         for (int i = 0; i < arr.length; i++) {
            try {
               System.out.println("���ڸ� �Է��ϼ��� : ");
               arr[i] = Integer.parseInt(sc.nextLine());
            } 
            catch (Exception e) {
               System.out.println("���ڸ� �Է����ּ���");
               i--; // i ���ڰ� ��� �ö󰡰� �־��ٴ°� ����?
            }
         }break;
      }

      System.out.print("���� �� : ");
      for (int i = 0; i < arr.length; i++) {

         System.out.print(arr[i]+ " ");
      }

      bubbleSort(arr);

      System.out.print("\n���� �� : ");
      for (int i = 0; i < arr.length; i++) {

         System.out.print(arr[i]+ " ");
      }
   }
}