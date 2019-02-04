package first_jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class disconnectedRowSetFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet crs = factory.createCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("SYSTEM");
			crs.setPassword("o1234");
			crs.setCommand("select id,name,email from a");
			crs.execute();
			while (crs.next()) {
				System.out.println(crs.getInt(1) + " : " + crs.getString(2) + " : " + crs.getString(3));
			}
			crs.moveToInsertRow();
			crs.updateInt(1, 432);
			crs.updateString(2, "aao");
			crs.updateString(3, "aao@mail");
			crs.insertRow();
			crs.moveToCurrentRow();
			System.out.println("Inserted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
