package first_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class practice {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "o1234");
			st = con.createStatement();
			int x = st.executeUpdate("insert into A values(101,'sm','sm@gmail')");
			if (x > 0)
				System.out.println("Successfully uploaded");
			else
				System.out.println("Sorry");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				System.out.println("not closed");
			}
		}
	}
}
