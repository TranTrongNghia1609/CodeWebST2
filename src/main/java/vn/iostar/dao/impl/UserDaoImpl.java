package vn.iostar.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostar.configs.DBconect;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

public class UserDaoImpl implements IUserDao{
	

	@Override
	public UserModel findByUsername(String username) {
		String sql = "select * from users where username = ?";
		try {
			Connection conn = new DBconect().getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("avatar"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createddate"));
				return user;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		return null;	
	}
	
	public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserModel user = userDao.findByUsername("nghia");
        System.out.println(user);
    }

}
