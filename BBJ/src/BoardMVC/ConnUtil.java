package BoardMVC;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class ConnUtil {
	private static DataSource ds;
	
	static {
		try {
	        Context initContext = new InitialContext();
	        ds =(DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
	     } catch (NamingException e) {
	            System.out.println("Connection 생성 실패");
	            e.printStackTrace();
	     }
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}