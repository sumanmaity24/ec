package first_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Connect.ConnectUtil;

public class resultsetScroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectUtil.getConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from A");
			System.out.println("forward");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
			System.out.println("backword");
			while (rs.previous()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
			System.out.println("1st");
			rs.first();
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			System.out.println("last");
			rs.last();
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			System.out.println("particular row");
			rs.absolute(2);
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			System.out.println("next to 2nd record");
			rs.relative(2);
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(rs, st, con);
		}
	}

}
