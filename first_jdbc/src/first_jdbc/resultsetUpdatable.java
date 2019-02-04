package first_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Connect.ConnectUtil;

public class resultsetUpdatable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectUtil.getConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select id,name,email from a");
			System.out.println("All");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
			System.out.println("Insert");
			rs.moveToInsertRow();
			rs.updateInt(1, 324);
			rs.updateString(2, "jlc");
			rs.updateString(3, "jlc@mail");
			rs.insertRow();
			System.out.println("Update");
			rs.absolute(4);
			rs.updateString(2, "none");
			rs.updateString(3, "none@mail");
			rs.updateRow();
			System.out.println("Delete");
			rs.absolute(3);
			rs.deleteRow();
			System.out.println("All after");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(rs, st, con);
		}
	}

}
