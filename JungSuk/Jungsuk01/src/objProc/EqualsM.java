package objProc;

class Person{
	long id;
	
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			return id == ((Person)obj).id;
		} else {
			return false;
		}
	}
	
	Person(long id){
		this.id = id;
	}
}


public class EqualsM {
	public static void main(String[] args) {
		Person p1 = new Person(81818181818L);
		Person p2 = new Person(8181811818L);
		
		if(p1.equals(p2)) {
			System.out.println("같습니다");
		} else {
			System.out.println("다릅니다.");
		}
	}
}
