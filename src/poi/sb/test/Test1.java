package poi.sb.test;


import poi.sb.biz.UserInfoBIZ;
import poi.sb.domain.UserInfo;

public class Test1 {
	public static void main(String[] args) {
		UserInfoBIZ userInfoBIZ = new UserInfoBIZ();
		String username = "17862921529";
		String password = "123456";
		UserInfo userInfo = userInfoBIZ.getUserInfo(username, password);

		if (userInfo.getUserId() > 0) {
			System.out.println("登陆成功");
		} else {
			System.out.println("用户名或密码错误!");
		}
	}
}
