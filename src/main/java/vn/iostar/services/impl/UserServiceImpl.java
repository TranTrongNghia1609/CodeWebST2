package vn.iostar.services.impl;
import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.models.UserModel;
import vn.iostar.services.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	
	public UserModel findByUserName(String username) {
		return userDao.findByUsername(username);
		
	}
	
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
				return user;
			}
			return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		userDao.insert(new UserModel(username, email, fullname,password,null,5,phone,date));
		return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}
	
}
