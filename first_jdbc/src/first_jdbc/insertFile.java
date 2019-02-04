package first_jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.StringTokenizer;

import com.Connect.ConnectUtil;

public class insertFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "E:\\my_dp.jpg";
		String absFileName = filename;
		StringTokenizer tok = new StringTokenizer(filename, "\\");
		while (tok.hasMoreTokens()) {
			filename = tok.nextToken();
		}
		Connection con = null;
		PreparedStatement ps = null;
		FileInputStream fis = null;
		try {
			con = ConnectUtil.getConnection();
			ps = con.prepareStatement("insert into datatable values(?,?,?)");
			ps.setInt(1, 108);
			ps.setString(2, filename);
			File image = new File(absFileName);
			fis = new FileInputStream(image);
			ps.setBinaryStream(3, fis, (int) image.length());
			ps.executeUpdate();
			System.out.println("Inserted");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectUtil.cleanUp(ps, con);
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
		}
	}

}
