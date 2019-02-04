package first_jdbc;

import java.sql.*;

public class retrive {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		try {
			int sid=10;
			String sname="sm";
			con=conctn.getMySqlConnection();
			String sql=String.format("select * from jlcstudents where sname=? and sid=?");
			s=con.prepareStatement(sql);
			s.setInt(2, sid);
			s.setString(1, sname);
			rs=s.executeQuery();
			System.out.println("id\tname\tmail\t\tphone");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String mail=rs.getString(3);
				long phone=rs.getLong(4);
				System.out.println(id+"\t"+name+"\t"+mail+"\t"+phone);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			conctn.cleanUp(rs, s, con);
		}
	}

}
