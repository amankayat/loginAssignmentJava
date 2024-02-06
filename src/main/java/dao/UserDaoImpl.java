package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.PasswordNotMatchException;
import exception.UserNotFoundException;
import model.UserData;
import utility.DBConnection;
import utility.QueryMapper;
import dao.UserDao;
public class UserDaoImpl implements UserDao {
	
	
	@Override
	public boolean createUser(UserData usr) {
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(QueryMapper.INSERT_USER);
			ps.setString(1, usr.getUsername());
			ps.setString(2, usr.getPassword());
			
			int count = ps.executeUpdate();
			if(count==1) {
				return true;
			}else
				return false;
			
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		 }
		
		
	}

	@Override
	public UserData getUserByName(String name) {
		UserData olduser = new UserData() ;
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(QueryMapper.GET_USER);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				
				olduser.setUsername(rs.getString(2));
				olduser.setPassword(rs.getString(3));
				
				return olduser;
			}else {
				throw new UserNotFoundException("given user is not exist..");
			}
			
			
			
		 }catch(SQLException | UserNotFoundException e) {
			 System.out.print("aman");
			 throw new RuntimeException(e);
		 }
	}

	@Override
	public boolean verifyUser(UserData usr) {
		
		try {
			
			
			
		UserData olduser = getUserByName(usr.getUsername());
			
			
			if(olduser.getUsername()!=null) {
				
				if(olduser.getPassword().equals(usr.getPassword())){
					return true;
				}else {
					throw new PasswordNotMatchException("password not match please try again....");
				}
				
				
				
			}else
			{
				throw new UserNotFoundException("user with this username is not exist..");
			}
			
		 }catch( UserNotFoundException | PasswordNotMatchException e) {
			 System.out.print("aman");
			 throw new RuntimeException(e);
		 }
		
	}

	

	@Override
	public boolean updateUser(UserData usr) {
		try {
			Connection conn = DBConnection.getconnection();
			PreparedStatement ps = conn.prepareStatement(QueryMapper.UPDATE_USER);
			UserData olduser = getUserByName(usr.getUsername());
			
			if(olduser!=null) {
				
				
				ps.setString(2, usr.getUsername());
				ps.setString(1,usr.getPassword());
				
				int count = ps.executeUpdate();
				if(count==1) {
					return true;
				}else
					return false;
				
			}else
			{
				throw new UserNotFoundException("the user you want to update it's not exist..");
			}
			
		 }catch(SQLException | UserNotFoundException e) {
			 throw new RuntimeException(e);
		 }
		
	}

}
