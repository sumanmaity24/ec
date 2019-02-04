package first_jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.Connect.ConnectUtil;

public class insertCall {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = ConnectUtil.getConnection();
			cst = con.prepareCall("call PROCEDURE_MARKSHEET(?,?,?,?)");
			cst.setInt(1, 216);
			cst.setInt(2, 65);
			cst.setInt(3, 75);
			cst.setInt(4, 85);
			boolean b1 = cst.execute();
			if (!b1)
				System.out.println("SUccess");
			else
				System.out.println("Sorry");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(cst, con);
		}
	}

}
