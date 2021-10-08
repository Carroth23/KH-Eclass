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

               if(0 < menu && menu < 4) {break;} // 제대로 된 값이 입력됬을 경우 while 탈출
               System.out.println("메뉴를 다시 확인해주세요.");
            }catch(Exception e) {
               System.out.println("메뉴는 숫자로 입력해야 합니다.");
            }
         }

         if(menu == 1) {
            int playerScore = 0;
            int target = (int)(Math.random() * 100 + 1); // 이게 맞추어야 하는 정답
            System.out.println("정답 : " + target);

            System.out.println("<< Game Start >>");
            while(true) {

               //---------------------------------------- Player turn
               System.out.println("<< Player Turn >>");
               System.out.print("Input Number : ");
               int input = Integer.parseInt(sc.nextLine()); // 답을 맞추기 위한 플레이어의 시도

               if(input < target) {
                  System.out.println("<< UP! >>");
               }else if(input > target) {
                  System.out.println("<< DOWN! >>");
               }else {
                  System.out.println("<< 정답! >>");   
                  System.out.println("플레이어가 승리했습니다.");
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
                  System.out.println("<< 정답! >>");
                  System.out.println("컴퓨터가 승리했습니다.");
                  comWin++;
                  break;
               }
            }
         }else if(menu == 2) {
            System.out.println("Player : " + playerWin + " 승 " + comWin + " 패 ");
            System.out.println("Computer : " + comWin + " 승 " + playerWin + " 패 ");
         }else if(menu == 3) {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
         }
      }

   }
}