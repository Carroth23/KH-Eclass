package manager;

import java.util.ArrayList;

import classes.Student;

public class Manager {
	private ArrayList<Student> students = new ArrayList<Student>();
//	<> ���ʸ�. Student �� ArrayList�� �����.
	public void addStudent(Student std) {
		this.students.add(std);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
}
