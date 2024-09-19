package vn.iostar.dao.impl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostar.configs.DBconect;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

public class UserDaoImpl implements IUserDao{
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
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
	
	
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users (email, username, fullname, password, avatar, roleid, phone, createddate) VALUES (?,?,?,?,?,?,?,?)";

				try {
				conn = new DBconect().getDatabaseConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getUsername());	
				ps.setString(3, user.getFullname());			
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getImages());
				ps.setInt(6,user.getRoleid());
				ps.setString(7,user.getPhone());
				ps.setDate(8, user.getCreateDate());
				ps.executeUpdate();
				} catch (Exception e) {e.printStackTrace();}
	}

	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
		conn = new DBconect().getDatabaseConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
		conn = new DBconect().getDatabaseConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;		
	}

	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		try {
			IUserService service = new UserServiceImpl();
			IUserDao dao = new UserDaoImpl();
			dao.insert(new UserModel("ttnghia24@gmail.com","nghiatran1", "tran trong nghia", "123", null, 4, null, null));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
