import java.util.Scanner;

public class nakseo {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      
      int menu;
      int money = 0;
      int input;
      int output;

      while(true) {
         System.out.println("*** ATM �ùķ����� ***");
         System.out.println("1. �ܾ���ȸ");
         System.out.println("2. �Ա��ϱ�");
         System.out.println("3. ����ϱ�");
         System.out.println("4. �����ϱ�");
         System.out.print(">>");
         
         while(true){
            try {
               menu = Integer.parseInt(sc.nextLine());   
               break;
            }catch(Exception e) {
               System.out.println("���ڸ� �Է����ּ���.");
            }   
         }

         if(menu == 1) {
            System.out.println("���� �ܾ���" + money + "�� �Դϴ�.");
         }else if(menu == 2) {
            System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
            while(true) {
               try {
                  input = Integer.parseInt(sc.nextLine());
                  money += input; // ����ڰ� �Է��� ���� ���� ������ �ִ� ���� ���ؼ� ����.
                  System.out.println("���� �Է��Ͽ����ϴ�.");
                  break;
               }catch(Exception e) {
                  System.out.println("���ڸ� �Է� �� �ֽñ� �ٶ��ϴ�.");
               }   
            }
         }else if(menu == 3) {
            System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
            while(true) {
               try {
                  output = Integer.parseInt(sc.nextLine());
                  System.out.println("���� �Է��Ͽ����ϴ�.");
                  break;
               }catch(Exception e) {
                  System.out.println("���ڸ� �Է� �� �ֽñ� �ٶ��ϴ�.");
               }   
            }
            if(money >= output) { // ���� ���� money�� ��� �ݾ׺��� ũ�ٸ�,
               money -= output;  // ���� ���� money���� ��� �ݾ��� ����.
            }else {
               System.out.println("�ܾ��� �����մϴ�.");
            }
         }else if(menu == 4) {
            System.out.println("ATM�� �����մϴ�.");
            System.exit(0);
         }else {
            System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
         }
      }      
   }
}
