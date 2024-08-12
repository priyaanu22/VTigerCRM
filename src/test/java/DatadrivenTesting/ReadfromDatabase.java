package DatadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadfromDatabase {

	public static void main(String[] args) throws SQLException 
	{
		// Step 1: Create Driver object
		Driver dbDriver=new Driver();
		// Step 2: Register to JDBC Driver
		DriverManager.registerDriver(dbDriver);
		// Step 3: Establish JDBC connection
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel");
		// Step 4: Create statement
		Statement statement = connection.createStatement();
		// Step 5: Execute Query to fetch data
		ResultSet result=statement.executeQuery("select * from student;");
		
		while(result.next())
		{
			System.out.println(result.getInt("sid")+"\t"+result.getString("sname")+"\t"
							+result.getString("phNo")+"\t"+result.getString("course"));
		}
		
		// Step 6: Close
		
		connection.close();
		
		



	}

}
