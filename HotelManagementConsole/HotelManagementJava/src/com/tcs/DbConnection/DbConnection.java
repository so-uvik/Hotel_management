package com.tcs.DbConnection;

import java.sql.*;

public class DbConnection {

	
	private static final String url="jdbc:mysql://localhost:3306/hotelmanagementtcssprint";
	private static final String userName="root";
	private static final String password="xxxxxxxxxxxx";
	
	
	public static Connection DbConnector() {
		
		
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		Connection con =null;
		
		try {
			con=DriverManager.getConnection(url,userName,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
