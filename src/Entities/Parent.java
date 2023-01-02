package Entities;
import java.awt.Container;

import db.Data;

public class Parent {
	
	
	
	public static void storeInformation(String type ,String... args) {
		
		if (type.equals("Student")) {
			Data.storeStudent(args[0],args[1],Integer.parseInt(args[2]));
			return;
		}
		
		if (type.equals("Professor")) {
			String[] classes = args[2].split(",");
			Data.storeProfessor(args[0],args[1],classes);
		}
		
	}

}
