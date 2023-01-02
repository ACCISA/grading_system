package Entities;
import db.Data;

import java.awt.Container;

public class Student extends Parent{
	private final String type = "Student";
	private String first_name;
	private String last_name;
	private int student_id; // useless, can just set the student id in database methods
	private final Student a = new Student();
	
	public Student(String first, String last) {
	
		this.first_name = first;
		this.last_name = last;
		this.student_id = Data.getNewStudentId();
		
		
		
		Parent.storeInformation( type ,first_name, last_name, student_id + "");
	}
	
	public Student() {
		
	}
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	
}
