package vn.iostar.dao;
import vn.iostar.models.UserModel;
public interface IUserDao {
	UserModel findByUsername(String username);
	
}
