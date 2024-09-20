package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;
import vn.iostar.ultis.Constant;

@WebServlet(urlPatterns = { "/ForgotPassword" })
public class ForgotPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher(Constant.ForgotPassword).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("UTF-8");
		// Nhận dữ liệu từ request URL
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		String alertMsg = "";
		if (!password.equals(repassword)) {
			alertMsg = "Mật khẩu không khớp!!!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/ForgotPassword.jsp").forward(req, resp);
			return;
		}

		IUserService service = new UserServiceImpl();
		UserModel user = service.findByUserName(username);
		if (user != null) {
			if (!email.equals(user.getEmail())) {
				alertMsg = "Email không đúng!!!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/ForgotPassword.jsp").forward(req, resp);
				return;
			}
			service.resetpassword(username, email, password);
			alertMsg = "Đã đổi mật khẩu thành công,vui lòng đăng nhập";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/ForgotPassword.jsp").forward(req, resp);
		} else {
			alertMsg = "Tài khoản không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/ForgotPassword.jsp").forward(req, resp);
		}

	}
}
