package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertOperation {

	//making the required variable as Global
	static String dbURL = "jdbc:mysql://localhost:3306/studentdb";
	static String userName = "root";
	static String password = "Bickey@123";
	//initially making the connection null
	static Connection conn = null;
	
	//Step 1: Load/Register the Driver Class
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	//Step 2: Create a connection
			try {
				conn = DriverManager.getConnection(dbURL,userName,password);
				
	//Step 3: Create Statement
				//PreparedStatement
				//Retrieving particular record
				PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
				ps.setInt(1, 7);
				ps.setString(2, "Astha");
				ps.setString(3, "Manager");
				ps.setString(4, "India");
				ps.setInt(5, 89124);
				
	//Step 4: Execute Update -> This is for all operation except retrieval/select
				//executeUpdate return integer value
				int insertedRecord = ps.executeUpdate();
				//we use if statement here
				if(insertedRecord>0) { //if update, value is always > zero
					System.out.println("Number of updated record : "+insertedRecord);
					System.out.println("Record updated successfully!!");				
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
	//Step 5: Close Connection
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
