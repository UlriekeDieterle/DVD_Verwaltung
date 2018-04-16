package dvd.verwaltung.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static java.sql.Connection con = null;
	private static String localURL = "jdbc:mysql://127.0.0.1:3306/dvd_verwaltung?user=root&password=";	

	public static Connection connection() {
		if(con == null) {
			String url = null;
			try {
					Class.forName("com.mysql.jdbc.Driver");
                    url = localURL;
                    con = DriverManager.getConnection(url);
				
			} catch(SQLException e) {
				con = null;
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return con;
	}
}
