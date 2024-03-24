package graded_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GradedAssignment {

	public static void main(String[] args) throws SQLException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		Connection con = null;
		Statement st = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/GL?useSSL=false", 
					"root", 
					"1112");
			st = con.createStatement();
			
			String query = "create table  Employee (emp_id int primary key not null, NAME varchar(25),"
					+ " Salary int, email varchar(25), Phone_no varchar(25))";
			
			String query1 = "insert into Employee values(1, \"rahul\", 50000, \"rahul@xyz.com\", \"123456789\")";
			
			String query2 = "insert into Employee values(2, \"rohit\", 40000, \"rohit@xyz.com\", \"123456790\")";
			
			String query3 = "insert into Employee values(3, \"raju\", 88000, \"raju@xyz.com\", \"123456791\")";
			
			String query4 = "insert into Employee values(4, \"sunil\", 980000, \"sunil@xyz.com\", \"123456792\")";
			
			String query5 = "insert into Employee values(5, \"sathish\", 130000, \"sathish@xyz.com\", \"123456793\")";
			
			st.execute(query);
			st.execute(query1);
			st.execute(query2);
			st.execute(query3);
			st.execute(query4);
			st.execute(query5);
			
			String query6 = "select * from Employee";
			st.executeQuery(query6);
			
			String query7 = "Alter Table Employee Modify email varchar(30) not Null";
			st.executeUpdate(query7);
			
			String query8 = "insert into Employee values(6, \"joy\", 300000, \"joy@xyz.com\", \"123456796\")";
			String query9 = "insert into Employee values(7, \"babu\", 85000, \"babu@xyz.com\", \"123456797\")";
			
			st.execute(query8);
			st.execute(query9);
			
			String query10 = "Delete from Employee where emp_id in(3,4)";
			st.executeUpdate(query10);
			String query11 = "Delete From Employee";
			st.executeUpdate(query11);
			
			}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			st.close();
			con.close();
		}

	}

}
