package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtil {

	static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	static String dbURL = "jdbc:mysql://localhost:3306/studentdb";
	static String userName = "root";
	static String password = "Bickey@123";

	Connection conn = null;

	public Connection createConnection() {
		try {
			Class.forName(jdbcDriver);
			try {
				conn = DriverManager.getConnection(dbURL, userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void insertData(int id, String name, String designation, String country, int ssn) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, designation);
			ps.setString(4, country);
			ps.setInt(5, ssn);
			
			int insertedRows = ps.executeUpdate();
			if(insertedRows>0) {
				System.out.println("Record inserted successfully!!");
				System.out.println("Number of record inserted: "+insertedRows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				System.out.println("Connection Closed!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public void retriveAll() {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getString(1) + " , Name: " + rs.getString(2) + " ,Designation: "
						+ rs.getString(3) + " ,Country: " + rs.getString(4) + " ,SSN: " + rs.getString(5));
			}
			System.out.println("Record retrieved successfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void retriveUsingId(int num) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee where id=?");
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getString(1) + " , Name: " + rs.getString(2) + " ,Designation: "
						+ rs.getString(3) + " ,Country: " + rs.getString(4) + " ,SSN: " + rs.getString(5));
			}
			System.out.println("Record retrieved successfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteUsingID(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			int deletedRows = ps.executeUpdate();
			if (deletedRows > 0) {
				System.out.println("Number of deleted record/s: " + deletedRows);
				System.out.println("Record deleted successfully!!");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateUsingID(int id, String name, String designation, String country, int ssn) {
		try {
			PreparedStatement ps = conn
					.prepareStatement("update employee set name=?, designation=?,country=?,ssn=? where id=?");
			ps.setString(1, name);
			ps.setString(2, designation);
			ps.setString(3, country);
			ps.setInt(4, ssn);
			ps.setInt(5, id);
			int updatedRows = ps.executeUpdate();
			if (updatedRows > 0) {
				System.out.println("Number of updated record/s: " + updatedRows);
				System.out.println("Record updated successfully!!");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection Closed!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
