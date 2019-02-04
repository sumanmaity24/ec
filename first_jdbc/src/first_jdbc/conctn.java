package first_jdbc;

import java.sql.*;

public class conctn {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
	public static Connection getOracleConnection() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","o1234");
		return con;
	}
	public static Connection getMySqlConnection() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","m1234");
		return con;
	}
	public static void cleanUp(Statement s,Connection c)
	{
		try {
			if(s!=null)
				s.close();
			if(c!=null)
				c.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void cleanUp(ResultSet rs,Statement s,Connection c)
	{
		try {
			if(rs!=null)
				rs.close();
			if(s!=null)
				s.close();
			if(c!=null)
				c.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
