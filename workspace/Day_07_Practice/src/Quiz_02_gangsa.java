import java.util.Scanner;

public class Quiz_02_gangsa {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int bestScore = 0;
      
      int playerWin = 0;
      int comWin = 0;
      
      while(true) {
         System.out.println("== UP&DOWN Game ==");
         int menu = 0;

         while(true) {
            try {
               System.out.println("1. Game Start");
               System.out.println("2. Game Score");
               System.out.println("3. Exit");
               System.out.print(">> ");
               menu = Integer.parseInt(sc.nextLine());

               if(0 < menu && menu < 4) {break;} // ����� �� ���� �Է��� ��� while Ż��
               System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
            }catch(Exception e) {
               System.out.println("�޴��� ���ڷ� �Է��ؾ� �մϴ�.");
            }
         }

         if(menu == 1) {
            int playerScore = 0;
            int target = (int)(Math.random() * 100 + 1); // �̰� ���߾�� �ϴ� ����
            System.out.println("���� : " + target);

            System.out.println("<< Game Start >>");
            while(true) {

               //---------------------------------------- Player turn
               System.out.println("<< Player Turn >>");
               System.out.print("Input Number : ");
               int input = Integer.parseInt(sc.nextLine()); // ���� ���߱� ���� �÷��̾��� �õ�

               if(input < target) {
                  System.out.println("<< UP! >>");
               }else if(input > target) {
                  System.out.println("<< DOWN! >>");
               }else {
                  System.out.println("<< ����! >>");   
                  System.out.println("�÷��̾ �¸��߽��ϴ�.");
                  playerWin++;
                  break;
               }

               //---------------------------------------------- Computer turn
               System.out.println("<< Computer Turn >>");
               int com = (int)(Math.random()*100+1);
               System.out.println("Input Number : " + com);
               
               if(com < target) {
                  System.out.println("<< UP! >>");
               }else if(com > target) {
                  System.out.println("<< DOWN! >>");
               }else {
                  System.out.println("<< ����! >>");
                  System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�.");
                  comWin++;
                  break;
               }
            }
         }else if(menu == 2) {
            System.out.println("Player : " + playerWin + " �� " + comWin + " �� ");
            System.out.println("Computer : " + comWin + " �� " + playerWin + " �� ");
         }else if(menu == 3) {
            System.out.println("������ �����մϴ�.");
            System.exit(0);
         }
      }

   }
}