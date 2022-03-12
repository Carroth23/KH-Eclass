package generics;

import java.util.ArrayList;

class Fruit implements Eatable2{
	public String toString() {return "Fruit";}
}

class Apple extends Fruit 	{public String toString() {return "Apple";}}
class Grape extends Fruit 	{public String toString() {return "Grape";}}
class Toy				 	{public String toString() {return "Toy";}}

interface Eatable2 {}

public class 푸룻박스 {
	public static void main(String[] args) {
		FruitBox2<Fruit> fruitBox = new FruitBox2<>();
		FruitBox2<Apple> appleBox = new FruitBox2<>();
		FruitBox2<Grape> grapeBox = new FruitBox2<>();
//		FruitBox2<Grape> tgrapeBox = new FruitBox2<Apple>(); 제네릭 불일치
//		FruitBox2<Toy> toyBox = new FruitBox2<>(); Toy는 Fruit를 상속받지 않음
		Box2<Toy> toyBox = new Box2<>(); // 가능. Box2는 아무런 제약이 없기때문
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); 에러. Grape는 Apple의 자손이 아님.
		
	}
}
						// 상속과 인터페이스를 같이쓸땐 &를 써야함. , 아님
class FruitBox2<T extends Fruit/*& Eatable2*/> extends Box2<T>{}

class Box2<T>{
	ArrayList<T> list = new ArrayList<>(); // item을 저장할 list
	void add(T item)	{list.add(item);}
	T get(int i)		{return list.get(i);}
	int size()		{return list.size();}
	public String toString() {return list.toString();}
}
