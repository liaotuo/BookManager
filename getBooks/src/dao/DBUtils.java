package dao;

/***
 * 数据库工具类
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	// 获取数据库连接
	public static Connection getConnection() {
		Connection con = null;
		 final String DRIVER = "com.mysql.jdbc.Driver";
		 final String URL ="jdbc:mysql:///studb?useUnicode=true&amp;characterEncoding=UTF-8";
		 final String USER = "root"; //monitor
		 final String PWD = "12345"; //monitor
		/*final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=yjmonitor";
		final String USER = "monitor"; // monitor
		final String PWD = "monitor"; // monitor yjmonitor@123
*/
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PWD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
