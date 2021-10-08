// 하나의 소스파일에는 하나의 클래스만 작성하는 것이 바람직
class Hello1 {} // 소스파일의 이름은 public class이름과 일치
//public class Hello3{} // 하나의 소스파일에는 하나의 public class만 허용
class Hello4{} // public가 하나도 없다면 소스파일 이름은 class 아무거나 일치해도 상관없다.
public class Hello5{ // 파일명은 public class명과 일치해야함
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}