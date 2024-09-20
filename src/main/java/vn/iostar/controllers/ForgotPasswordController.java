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
public class ForgotPasswordController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher(Constant.ForgotPassword).forward(req, resp);
	}			
	protected void postForgotPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		IUserService service = new UserServiceImpl();
		UserModel user = service.findByUserName(username);
		if(user.getEmail().equals(email) && user.getUsername().equals(username)) {
			
	}
	}
}
