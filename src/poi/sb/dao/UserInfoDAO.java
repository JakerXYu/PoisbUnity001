package poi.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import poi.sb.domain.UserInfo;
import poi.sb.utils.ConnectionUtils;

public class UserInfoDAO {
	public UserInfo getUserInfo(String username, String password)
			throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionUtils.getConnection();
		String sqlString = "select userID,username,password from UserInfo where username = ? and password = ?";
		PreparedStatement pstat = conn.prepareStatement(sqlString);
		pstat.setString(1, username);
		pstat.setString(2, password);
		ResultSet rs = pstat.executeQuery();
		UserInfo uerInfo = new UserInfo();
		while (rs.next()) {
			uerInfo.setUserId(rs.getInt("userID"));
			uerInfo.setUserName(rs.getString("username"));
			uerInfo.setPassword(rs.getString("password"));
		}
		return uerInfo;
	}
}
