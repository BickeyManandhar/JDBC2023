package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrievalOperation {

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
				PreparedStatement ps = conn.prepareStatement("select * from employee where id = ?");
				ps.setInt(1, 1);
				
	//Step 4: Execute Query -> This is to Retrieve/Select data
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println("Record retrieved successfully!!");
					//only first row of column 1 to column 5 of database 
					System.out.println("ID: "+rs.getString(1)+ " , Name: "+rs.getString(2)+ " ,Designation: "+rs.getString(3)+ " ,Country: "+rs.getString(4)+ " ,SSN: "+rs.getString(5));
					
					//another way
					//System.out.println(rs.getString("id")+ " "+rs.getString("name")+ " "+rs.getString("designation")+ " "+rs.getString("country")+ " "+rs.getString("ssn"));
					
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
