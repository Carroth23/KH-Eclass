package electronic;

public class Book {

	private int id = 1001; // 디폴트 밸류(완전 초기값)
	private String title = "로미오와 줄리엣"; // 디폴트 밸류는 클래스 개발자가 초기에 세팅해두는 값
	private int price;

	public Book() {} // 생성자를 오버로딩 해두면 메인에서 에러가 안남
	public Book(int id, String title, int price){ // 생성자 constructor
		this.id = id; // 이런식으로 초기값 세팅할때 생성자를 사용
		this.title = title; // 컨스트럭터는 사용자가 초기에 넣는 값
		this.price = price;
	}
	
	public int getId() { 
		return id;
	}

	public void setId(int id) { // 객체 사용중 값을 변경할때 쓰는 값  1. 디폴트 밸류 2. 사용자의 컨스트럭터 3. 사용자의 세터 순서로 값이 들어간다
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}