package jungsuk;

public class Ex09_1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		String a = "하이";
		String b = "하이";
		if(a.equals(b)) {
			System.out.println("a와 b는 같다");
		} else {
			System.out.println("a와 b는 다르다");
		}
	}

}

// HashCode() 객체의 주소를 int로 변환해서 반환하는 메서드. native메서드이다.
// equals를 오버라이딩하면 해시코드도 같이 오버라이딩해야함. equals의 결과가 true인 두 객체의 해시코드는 같아야 하기때문

class Value{
	int value;
	
	Value(int value){
		this.value = value;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Value)) return false;
		
		Value v = (Value)obj;
		return this.value==v.value;
	}
	
}
