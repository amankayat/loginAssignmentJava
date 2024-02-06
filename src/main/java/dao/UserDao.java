package dao;

import model.UserData;

public interface UserDao {
	public boolean createUser(UserData usr);
	public UserData getUserByName(String name);
	public boolean verifyUser(UserData usr);
	
	public boolean updateUser(UserData usr);
}
