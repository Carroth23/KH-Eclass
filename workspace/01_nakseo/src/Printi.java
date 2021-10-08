
public class Printi {
	public String delimiter = "";
	
	public Printi(String delimiter){
		this.delimiter = delimiter;
	}
	
	public void A() {
		System.out.println(this.delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	
	public void B() {
		System.out.println(this.delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}
