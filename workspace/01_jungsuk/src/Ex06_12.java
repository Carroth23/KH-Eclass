class Car {
	String color;
	String geartype;
	int door;
	
	Car(){}
	Car(String a, String b, int c){
		color = a;
		geartype = b;
		door = c;
	}
}
public class Ex06_12 {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "white";
		c1.geartype = "auto";
		c1.door = 4;
		
		Car c2 = new Car("black", "menual", 6);
		
		System.out.println("c1 = " + c1.color + "\t" + c1.geartype + "\t" + c1.door);
		System.out.println("c2 = " + c2.color + "\t" + c2.geartype + "\t" + c2.door);
	}
}
