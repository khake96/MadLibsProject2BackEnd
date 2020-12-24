package com.revature.madlibs.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* This Revature Madlibs SQL Connection class provides 
 * static access to the DB connection to the DB to be reused
 * throughout the Revature Madlibs app.
 */

public class PostgresSqlConnection {
		
		public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks will need to register our Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		String url = "jdbc:postgresql://localhost:5432/madlibs";
//		String username = "postgres";
//		String password = "postgres"; 
		
		String url = System.getenv("postgresPath");
		String username = System.getenv("postgresUserName");
		String password = System.getenv("postgresPassword"); 
		
		return DriverManager.getConnection(url, username, password);
	}
	
// Allows testing of the connection before proceeding too far into the coding process	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		try(Connection conn = PostgresSqlConnection.getConnection()) {
//			System.out.println("Success.");
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();		
//		}
//	} // end static main
} // end class
	

