package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Connections {

    public static Connection con;

    public static void connect() {
        if (con != null) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        }
        String url = "";
        try {
            con = (Connection) DriverManager.getConnection(url, "", "");
            System.out.println("[DB] Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("[DB] Disconnected");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Cant close connection");
                e.printStackTrace();
            }
        }
    }

}


