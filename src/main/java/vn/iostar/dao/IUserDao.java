package vn.iostar.dao;
import vn.iostar.models.UserModel;
public interface IUserDao {
	UserModel findByUsername(String username);
	void insert(UserModel user);
	void update(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

	
}
