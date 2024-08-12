package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtility 
{
	Connection connection;
	Statement statement;
	
	/**
	 * This method initialies database
	 */
	public void databaseInt(String url, String user,String pwd)
	{
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
		
	}

	
	public  List<Object> readfromDatabase(String query, String colName)
	{
		ResultSet result= null;
		try {
			result = statement.executeQuery(query);
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	
		
	List<Object>list=new ArrayList<Object>();
		try {
			while(result.next())
			{
				list.add(result.getObject(colName));
			}
		  }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**
	 * This method is used to modify database
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query)
	{
		int result=0;
		try {
			return statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * This method clases database connection
	 */
	public void closeDatabase()
	{
		try {
			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
}


