package vn.iostar.controllers;

import vn.iostar.ultis.Constant;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionIdListener;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/dangnhap" })

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -5660203773190134466L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession session = req.getSession(false);
//		if(session != null && session.getAttribute("account")!=null) {
//			resp.sendRedirect(req.getContextPath()+"/waiting");
//			return;
//		}
//		
//		//Check cookie
//		Cookie[] cookies = req.getCookies();
//		if(cookies != null) {
//			for(Cookie cookie : cookies) {
//				if(cookie.getName().equals("username")) {
//					session = req.getSession(true);
//					session.setAttribute("username", cookie.getValue());
//					resp.sendRedirect(req.getContextPath() + "/waiting");
//					return;
//				}
//			}
//		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/Login.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Nhan du lieu tu request URL
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		String alertMsg = "";
		// Kiểm tra điều kiện
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được để trống";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/Login.jsp").forward(req, res);
			return;
		}
		IUserService service = new UserServiceImpl();
		UserModel user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);

			if (isRememberMe) {
				saveRemeberMe(res, username);
			}
			res.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/Login.jsp").forward(req, res);
		}
	}

	
	

	private void saveRemeberMe(HttpServletResponse responese, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		responese.addCookie(cookie);
	}

}
