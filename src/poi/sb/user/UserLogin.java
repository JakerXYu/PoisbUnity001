package poi.sb.user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poi.sb.biz.UserInfoBIZ;
import poi.sb.domain.UserInfo;

/**
 * 测试登录用的
 * 
 * @author jxy
 *
 */
public class UserLogin extends HttpServlet {
	private UserInfoBIZ userInfoBIZ;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		userInfoBIZ = new UserInfoBIZ();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserInfo userInfo = userInfoBIZ.getUserInfo(username, password);
		Writer outWriter = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		if (userInfo.getUserId() > 0) {
			outWriter.write("true");
			System.out.println("true");
		} else {
			outWriter.write("false");
			System.out.println("false");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
