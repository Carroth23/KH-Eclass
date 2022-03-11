package generics;

import java.util.ArrayList;

class Fruit2					{public String toString() {return "Fruit";}}
class Apple2	 extends Fruit2	{public String toString() {return "Apple";}}
class Grape2	 extends Fruit2	{public String toString() {return "Grape";}}

class Juice {
	String name;
	
	Juice(String name)			{this.name = name + "Juice";}
	public String toString() 	{return name;}
}

class Juicer{
	static Juice makeJuice(FruitBox3<? extends Fruit2> box) {
		String tmp = "";
		for(Fruit2 f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}
public class 와일드카드 {
	public static void main(String[] args) {
		// 와일드카드 : 하나의 참조 변수로 대입된 타입이 다른 객체를 참조 가능
		FruitBox3<Fruit2> fruitBox = new FruitBox3<Fruit2>();
		
		// Fruit2와 그 자손들 원래는 Apple인데 와일드카드 사용
		FruitBox3<? extends Fruit2> appleBox = new FruitBox3<Apple2>();
		appleBox = new FruitBox3<Grape2>();
		appleBox = new FruitBox3<Apple2>();
		appleBox = new FruitBox3<Fruit2>();
		// 와일드카드는 제네릭클래스를 매개변수로 받는 메서드에서 사용가능
		
		
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Fruit2());
		appleBox.add(new Grape());
		appleBox.add(new Apple2());
		appleBox.add(new Apple2());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	}
}

class FruitBox3<T extends Fruit2> extends Box3<T>{}

class Box3<T>{
	ArrayList<T> list = new ArrayList<>();
	void add(T item) 	{list.add(item);}
	T get(int i)			{return list.get(i);}
	ArrayList<T> getList(){return list;}
	int size()			{return list.size();}
	public String toString() {return list.toString();}
}
