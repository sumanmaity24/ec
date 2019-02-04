package first_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.Connect.ConnectUtil;

public class rsMetaData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=ConnectUtil.getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from a");
			ResultSetMetaData md=rs.getMetaData();
			System.out.println("cols : "+md.getColumnCount());
			for (int i = 1; i < md.getColumnCount(); i++) {
				System.out.print("column name : "+md.getColumnName(i)+"\t");
				System.out.print("class name : "+md.getColumnClassName(i)+"\t");
				System.out.print("table name : "+md.getTableName(i)+"\t");
				System.out.print("type name : "+md.getColumnTypeName(i)+"\t");
				System.out.println("size : "+md.getPrecision(i));
			}
			System.out.println(": "+md);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			ConnectUtil.cleanUp(rs, st, con);
		}
	}

}
