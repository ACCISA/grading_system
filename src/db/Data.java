package db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO DATABASE JDBC

public class Data{

	public static int getNewStudentId() {
		
		return dbGetLastStudentId()+1;
		
	}
	
	public static void storeStudent(String first, String last, int student_id) {
		
		String sql = "INSERT INTO students (first_name, last_name, student_id) VALUES (?,?,?) ";
		try {
			
			PreparedStatement stmt = Connections.con.prepareStatement(sql);
			stmt.setString(1,first);
			stmt.setString(2, last);
			stmt.setInt(3, student_id);
			stmt.execute();
	
			
		} catch (SQLException e) {
			System.out.println("[DB] Error saving student creation");
			e.printStackTrace();
		}
	}
	
	public static void storeProfessor(String first, String last, String[] classes) {
		String sql = "INSERT INTO professors (first_name, last_name, professor_id) values (?,?,?)";
		final int professor_id = getLastProfessorId();
		try {
			PreparedStatement stmt = Connections.con.prepareStatement(sql);
			stmt.setString(1, first);
			stmt.setString(2, last);
			stmt.setInt(3, professor_id);
			stmt.execute();
	
		} catch (SQLException e) {
			System.out.println("[DB] Error saving professor creation");
			e.printStackTrace();
		}
		storeProfessorClasses(professor_id,classes);
	}
	
	private static void storeProfessorClasses(int profId, String[] classes) {

		// SECURITY ISSUE
		// not a good thing. Will need to change for some way to queue queries
		// make sure to limit classes and verify someone isn't trying to crash the database/application
		for (String single_class :  classes) {
			String sql = "INSERT INTO classes (professor_id, class) VALUES (?,?)";
			try {
				PreparedStatement stmt = Connections.con.prepareStatement(sql);
				stmt.setInt(1, profId);
				stmt.setString(2, single_class);
				stmt.execute();
				
			} catch (SQLException e) {
				System.out.println("[DB] Error trying to store classes from professor creation");
				e.printStackTrace();
			}
		}
	}
	
	private static int getLastProfessorId() {
		String sql = "SELECT professor_id FROM grading ORDER BY professor_id DESC LIMIT 1";
		try {
			PreparedStatement checkStmt = Connections.con.prepareStatement(sql);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next()) {
				String getLastId = rs.getString("professor_id");
				return Integer.parseInt(getLastId);
			}
			return 0;
		} catch (SQLException e) {
			System.out.println("[DB] Error trying to get last professor id");
			e.printStackTrace();
			return -1;
		}
	}
	
	private static int dbGetLastStudentId() {
		String sql = "SELECT student_id FROM grading ORDER BY student_id DESC LIMIT 1";
		try {
			PreparedStatement checkStmt = Connections.con.prepareStatement(sql);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next()){
				String getLastId = rs.getString("student_id");
				return Integer.parseInt(getLastId);
						
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	

	
}
