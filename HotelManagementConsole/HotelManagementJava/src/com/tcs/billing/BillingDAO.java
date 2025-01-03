package com.tcs.billing;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.tcs.DbConnection.DbConnection;
public class BillingDAO{
	
public static String updateBill = "update billing set finalPrice = ? where id =?";
	
	
public static boolean billingDb(int finalPrice,int id )throws SQLException {
	Connection con = null;
	PreparedStatement pstmt = null;
	try {
		con = DbConnection.DbConnector();
		pstmt = con.prepareStatement(updateBill);
		pstmt.setInt(1, finalPrice);
		pstmt.setInt(2, id);

		int rowAffected=pstmt.executeUpdate();
		if(rowAffected>0) return true;

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		pstmt.close();
		con.close();
	}
	return false;
	}
	
	

}
