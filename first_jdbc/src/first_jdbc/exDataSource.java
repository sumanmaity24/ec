package first_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Connect.ConnectUtil;

import oracle.jdbc.pool.OracleDataSource;

public class exDataSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OracleDataSource ods = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("SYSTEM");
			ods.setPassword("o1234");
			con = ods.getConnection();
			pst = con.prepareStatement("select * from a");
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(rs, pst, con);
		}
	}

}
