package studentManager;
import java.util.ArrayList;

import student.Student;

public class StudentManager {
	ArrayList student = new ArrayList();
	
	public void addStudent(Student s) {
		this.student.add(s);
	}
	
	public ArrayList getStudent(){
		return student;
	}
}
