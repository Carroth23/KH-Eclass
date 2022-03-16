package kh.papago.test;

// 네이버 기계번역 (Papago SMT) API 예제
public class main {

    public static void main(String[] args) {
        String result = NaverDAO.translate("번역해주세요");
        System.out.println(result);
    }
}