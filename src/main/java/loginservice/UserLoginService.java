package loginservice;

import model.UserData;

public interface UserLoginService {
	public boolean createUser(UserData usr);
	public UserData getUserByName(String name);
	public boolean verifyUser(UserData usr);
	
	public boolean updateUser(UserData usr);
	
	public int getuserid(String name);
	public void userlist();
}
