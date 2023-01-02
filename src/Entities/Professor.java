package Entities;

public class Professor extends Parent{

	private final String type = "Professor";
	private String first_name;
	private String last_name;
	private String classes;

	public Professor(String first_namei, String last_namei, String classesi) {
	
		this.first_name = first_namei;
		this.last_name = last_namei;
		this.classes = classesi;
		
		storeInformation(type, first_name, last_name, classes);
	}
	
}
