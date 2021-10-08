package manager;

import java.util.ArrayList;

import classes.Student;

public class Manager {
	private ArrayList<Student> students = new ArrayList<Student>();
//	<> 제너릭. Student 형 ArrayList를 만든다.
	public void addStudent(Student std) {
		this.students.add(std);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
}
