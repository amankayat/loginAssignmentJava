package utility;

public interface QueryMapper {
public static final String INSERT_USER = "insert into userdata(username,password) values(?,?);";

public static final String GET_USER = "select userid,username,password from userdata where username=?;";

public static final String UPDATE_USER ="update userdata set password=? where username=?;";

public static final String GET_ID = "select userid from userdata where username=?;";

public static final String SHOW_USERS = "select userid,username,password from userdata;";
}
