package first_jdbc;

import java.sql.*;

public class insert {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement s=null;
		try {
			con=conctn.getMySqlConnection();
			int id=10;
			String name="sm";
			String mail="sm@gmail.com";
			long phone=999999998l;
			String sql="insert into jlcstudents values(?,?,?,?)";
			s=con.prepareStatement(sql);
			s.setInt(1, id);
			s.setString(2, name);
			s.setString(3, mail);
			s.setLong(4, phone);
			int i=s.executeUpdate();
			if(i==1)
				System.out.println("recorded");
			else
				System.out.println("not recorded");
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			conctn.cleanUp(s, con);
		}
	}

}
