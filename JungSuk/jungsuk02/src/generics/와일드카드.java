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
		Box3 b = null;
		Box3<String> bStr = null;
		
		b = (Box3)bStr;
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
