import java.util.Scanner;

public class nakseo {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      
      int menu;
      int money = 0;
      int input;
      int output;

      while(true) {
         System.out.println("*** ATM 시뮬레이터 ***");
         System.out.println("1. 잔액조회");
         System.out.println("2. 입금하기");
         System.out.println("3. 출금하기");
         System.out.println("4. 종료하기");
         System.out.print(">>");
         
         while(true){
            try {
               menu = Integer.parseInt(sc.nextLine());   
               break;
            }catch(Exception e) {
               System.out.println("숫자를 입력해주세요.");
            }   
         }

         if(menu == 1) {
            System.out.println("현재 잔액은" + money + "원 입니다.");
         }else if(menu == 2) {
            System.out.println("얼마를 입금하시겠습니까?");
            while(true) {
               try {
                  input = Integer.parseInt(sc.nextLine());
                  money += input; // 사용자가 입력한 값과 원래 가지고 있던 값을 더해서 누적.
                  System.out.println("정상 입력하였습니다.");
                  break;
               }catch(Exception e) {
                  System.out.println("숫자를 입력 해 주시기 바랍니다.");
               }   
            }
         }else if(menu == 3) {
            System.out.println("얼마를 출금하시겠습니까?");
            while(true) {
               try {
                  output = Integer.parseInt(sc.nextLine());
                  System.out.println("정상 입력하였습니다.");
                  break;
               }catch(Exception e) {
                  System.out.println("숫자를 입력 해 주시기 바랍니다.");
               }   
            }
            if(money >= output) { // 내가 가진 money가 출금 금액보다 크다면,
               money -= output;  // 내가 가진 money에서 출금 금액을 뺄셈.
            }else {
               System.out.println("잔액이 부족합니다.");
            }
         }else if(menu == 4) {
            System.out.println("ATM을 종료합니다.");
            System.exit(0);
         }else {
            System.out.println("메뉴를 다시 확인해주세요.");
         }
      }      
   }
}
