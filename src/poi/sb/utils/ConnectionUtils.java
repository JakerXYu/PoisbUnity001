package poi.sb.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class ConnectionUtils {
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	private static DataSource ds;
	static {

		Properties properties = new Properties();
		InputStream is = ConnectionUtils.class
				.getResourceAsStream("/mysql.properties");
		try {
			properties.load(is);
			ds = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = threadLocal.get();
		if (conn == null || conn.isClosed()) {
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}

	public static void closeConnection() {
		Connection conn = threadLocal.get();
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			threadLocal.remove();
		}
	}
}