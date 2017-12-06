package poi.sb.biz;

import java.sql.SQLException;

import poi.sb.dao.UserInfoDAO;
import poi.sb.domain.UserInfo;
import poi.sb.utils.ConnectionUtils;

public class UserInfoBIZ {
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	public UserInfo getUserInfo(String username, String password){
		UserInfo userInfo;
		try {
			ConnectionUtils.getConnection().setAutoCommit(false);
			userInfo = this.userInfoDAO.getUserInfo(username, password);
			ConnectionUtils.getConnection().commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				ConnectionUtils.getConnection().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally {
			ConnectionUtils.closeConnection();
		}
		return userInfo;
	}
}
