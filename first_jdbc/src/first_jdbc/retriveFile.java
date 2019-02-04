package first_jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Connect.ConnectUtil;

public class retriveFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "dp.jpg";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			con = ConnectUtil.getConnection();
			String sql = "select name,data from datatable where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 108);
			rs = ps.executeQuery();
			while (rs.next()) {
				File image = new File("G:\\" + fileName);
				fos = new FileOutputStream(image);
				byte[] buffer = new byte[1];
				InputStream is = rs.getBinaryStream(2);
				while (is.read(buffer) > 0) {
					fos.write(buffer);
				}
			}
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			ConnectUtil.cleanUp(rs, ps, con);
		}
	}

}
