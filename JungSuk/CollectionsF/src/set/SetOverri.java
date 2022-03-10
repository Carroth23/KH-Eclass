package set;

import java.util.*;

public class SetOverri {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 20));
		set.add(new Person("David", 20));
		System.out.println(set);
	}


}

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 클래스만들면 equals랑 hashcode는 오버라이딩 해주는게 좋다.
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person)obj;
		return p.name.equals(this.name) && p.age == this.age;
	}
	
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	public String toString() {
		return name + " : " + age;
	}
}