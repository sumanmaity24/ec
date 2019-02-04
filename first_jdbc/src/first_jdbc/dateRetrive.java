package first_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.Connect.ConnectUtil;

public class dateRetrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectUtil.getConnection();
			pst = con.prepareStatement("select * from datetest");
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				Date dt = rs.getDate(2);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				String dop = sdf.format(dt);
				System.out.println(id + " : " + dop);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(rs, pst, con);
		}
	}

}
