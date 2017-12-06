package poi.sb.user;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poi.sb.biz.UserInfoBIZ;
import poi.sb.domain.UserInfo;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }

    private UserInfoBIZ userInfoBIZ;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		userInfoBIZ = new UserInfoBIZ();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserInfo userInfo = userInfoBIZ.getUserInfo(username, password);
		Writer outWriter = response.getWriter();
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
