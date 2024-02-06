package loginmain;

import java.util.Scanner;

import loginservice.UserLoginService;
import loginservice.UserLoginServiceImpl;
import model.UserData;

public class MainApp {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 UserLoginService obj = new UserLoginServiceImpl();
	
	
	
	 char ch;
	 do {
		 System.out.println("\n1.AdminLogin\n2.Login");
		 int choice = sc.nextInt();
	 switch(choice) {
	 case 1:
		 UserData newusr = new UserData();
		 System.out.print("enter admin username: ");
		 String aname = sc.next();
		 newusr.setUsername(aname);
		 System.out.print("enter admin password: ");
		 String apass = sc.next();
		 newusr.setPassword(apass);
		 if(obj.verifyUser(newusr)) {
			 System.out.println("Admin verified successfully..");
			 char ch1;
			 do {
				 System.out.println("\n1.Userlist\n2.Add user");
				 int choice2 = sc.nextInt();
				 switch(choice2) {
				 case 1:
					 obj.userlist();
					 
					 break;
				 case 2:
					 UserData newusr1 = new UserData();
					 System.out.print("enter new username: ");
					 String iname = sc.next();
					 newusr1.setUsername(iname);
					 System.out.print("enter admin password: ");
					 String ipass = sc.next();
					 newusr1.setPassword(ipass);
					 if(obj.createUser(newusr1)) {
						 System.out.println("user added successfully..");
					 }else {
						 System.out.print("error in creating user..");
					 }
					 
					 break;
				default:System.out.print("wrong input!!");
						 
				 }
				 System.out.println("do you want to continue admin panel? type y/n: ");
				 ch1 = sc.next().charAt(0);
			 }while(ch1=='y'||ch1=='Y');
			 
			
			
			 
		 }else {
			 System.out.print("error in admin login...");
		 }
		
		
		 break;
	 case 2:
		
		 System.out.print("enter username: ");
		 String name = sc.next();
		 
		 System.out.print("enter password: ");
		 String pass = sc.next();
		 UserData usr = new UserData(name,pass);
		 
		 if(obj.verifyUser(usr)) {
			 System.out.print("user verified successfully..");
			 char ch2;
			 do {
				 
			 
			 System.out.println("\n1.userdetails\n2.update user");
			 int choice1 = sc.nextInt();
			 switch(choice1) {
			 case 1:
				 UserData getuser = obj.getUserByName(name);
				 System.out.println("userid = "+obj.getuserid(name));
				 System.out.println("username = "+getuser.getUsername());
				 System.out.println("username = "+getuser.getPassword());
				 
				 break;
			 case 2:
				 UserData usr1=new UserData();
				 System.out.println("**you can only change password of user**");
				 System.out.print("enter username: ");
				 String uname = sc.next();
				 System.out.print("enter new password: ");
				 String upass = sc.next();
				 usr1.setUsername(uname);
				 usr1.setPassword(upass);
				 if(obj.updateUser(usr1)) {
					 System.out.print("user updated succesfully..");
				 }else {
					 System.out.print("error in user updation..");
				 }
				 
				 
				 break;
				 default:System.out.print("wrong input!!");
			 }
			 System.out.println("do you want to continue Login panel? type y/n: ");
			 ch2 = sc.next().charAt(0);
			 }while(ch2=='y'||ch2=='Y');
		 }else {
			 System.out.print("user not verified.please try again..");
		 }
		 
		 break;
	default:
		System.out.print("wrong input!!");
	 }
	 System.out.println("do you want to continue main panel? type y/n: ");
	 ch = sc.next().charAt(0);
 }while(ch=='y'||ch=='Y');
 }
}
