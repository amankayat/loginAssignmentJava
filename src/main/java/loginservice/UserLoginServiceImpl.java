package loginservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDao;
import dao.UserDaoImpl;
import exception.UserNotFoundException;
import model.UserData;
import utility.DBConnection;
import utility.QueryMapper;

public class UserLoginServiceImpl implements UserLoginService{
	
	private UserDao ob = new UserDaoImpl();
	@Override
	public boolean createUser(UserData usr) {
		// TODO Auto-generated method stub
		return ob.createUser(usr);
	}

	@Override
	public UserData getUserByName(String name) {
		// TODO Auto-generated method stub
		return ob.getUserByName(name);
	}

	@Override
	public boolean verifyUser(UserData usr) {
		// TODO Auto-generated method stub
		return ob.verifyUser(usr);
	}

	
	@Override
	public boolean updateUser(UserData usr) {
		// TODO Auto-generated method stub
		return ob.updateUser(usr);
	}

	@Override
	public int getuserid(String name) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(QueryMapper.GET_ID);
			ps.setString(1, name);
			
			
			ResultSet rs  = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				throw new UserNotFoundException("User not found!!");
			}
			
			
		 }catch(SQLException | UserNotFoundException e) {
			 throw new RuntimeException(e);
		 }
	}

	@Override
	public void userlist() {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBConnection.getconnection();
			Statement cs = conn.createStatement();
			ResultSet rs = cs.executeQuery(QueryMapper.SHOW_USERS);
			System.out.println("**List of Users**");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				
			}
			
			
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }
	}

}
