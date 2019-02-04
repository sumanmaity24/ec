package first_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tryWithResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "o1234");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from a");) {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
