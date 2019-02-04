package first_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.Connect.ConnectUtil;

public class InsertCallIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = new Scanner(System.in);
		try {
			con = ConnectUtil.getConnection();
			pst = con.prepareStatement("insert into marksheet(id,a,b,c,total,average) values(?,?,?,?,?,?)");
			char ch = 'y';
			do {
				System.out.print("Enter ID : ");
				int id = sc.nextInt();
				System.out.print("Enter A : ");
				int a = sc.nextInt();
				System.out.print("Enter B : ");
				int b = sc.nextInt();
				System.out.print("Enter C : ");
				int c = sc.nextInt();
				System.out.print("Enter Total : ");
				int total = sc.nextInt();
				System.out.print("Enter Average : ");
				float avg = sc.nextFloat();
				pst.setInt(1, id);
				pst.setInt(2, a);
				pst.setInt(3, b);
				pst.setInt(4, c);
				pst.setInt(5, total);
				pst.setFloat(6, avg);
				pst.addBatch();
				System.out.print("Do you want to insert : ");
				ch = sc.next().charAt(0);
			} while (ch == 'y');
			int[] i = pst.executeBatch();
			if (i.length >= 0)
				System.out.println("Done");
			else
				System.out.println("Sorry");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(pst, con);
			sc.close();
		}
	}

}
