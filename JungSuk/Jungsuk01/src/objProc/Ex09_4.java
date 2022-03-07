package objProc;

import java.util.Objects;

class Card{
	String kind;
	int number;
	
	Card(){
		this("spade", 1);
	}
	
	Card (String kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		return "kind : " + kind + " number : " + number;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) {
			return false;
		}
		Card c = (Card)obj;
		return this.kind.equals(c.kind) && this.number == c.number;
	}
	
	public int hashCode() {
		return Objects.hash(kind, number);
	}
}
public class Ex09_4 {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		System.out.println(c1.toString());
		System.out.println(c2);
	}
}
