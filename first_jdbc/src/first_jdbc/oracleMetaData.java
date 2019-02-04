package first_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.Connect.ConnectUtil;

public class oracleMetaData {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectUtil.getConnection();
		DatabaseMetaData md = con.getMetaData();
		System.out.println("url : " + md.getURL());
		System.out.println("user : " + md.getUserName());
		System.out.println("major version : " + md.getDatabaseMajorVersion());
		System.out.println("minor version : " + md.getDatabaseMinorVersion());
		System.out.println("full join : " + md.supportsFullOuterJoins());
		System.out.println("product name : " + md.getDatabaseProductName());
		System.out.println("multiple rs : " + md.supportsMultipleOpenResults());
		System.out.println("db : " + md.getDatabaseProductName());
	}

}
