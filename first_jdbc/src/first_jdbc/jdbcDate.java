package first_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.Connect.ConnectUtil;

public class jdbcDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sid = 101;
		int d = 22;
		int m = 11;
		int y = 2018;
		Date dt = new Date(y - 1900, m - 1, d);
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectUtil.getConnection();
			DatabaseMetaData md = con.getMetaData();
			String db = md.getDatabaseProductName();
			String dop = "";
			System.out.println(db);
			if (db.equals("Oracle")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				dop = sdf.format(dt);
			}
			st = con.createStatement();
			String sql = String.format("insert into datetest values(%d,'%s')", sid, dop);
			st.executeUpdate(sql);
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(st, con);
		}
	}

}
