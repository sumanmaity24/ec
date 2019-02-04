package first_jdbc;

import java.sql.*;

public class insertBatchStatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			con = conctn.getMySqlConnection();
			st = con.createStatement();
			st.addBatch("insert into jlcstudents values(99,'sm','sm@gmail.com',9999999999)");
			st.addBatch("insert into jlcstudents values(98,'ms','ms@gmail.com',9999999998)");
			st.addBatch("insert into jlcstudents values(97,'m','m@gmail.com',9999999997)");
			st.addBatch("update jlcstudents set sphone=8999999999 where sid=98");
			st.addBatch("delete from jlcstudents where sid=97");
			int x[] = st.executeBatch();
			for (int i = 0; i < x.length; i++)
				System.out.println("recorded");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			conctn.cleanUp(st, con);
		}
	}

}
