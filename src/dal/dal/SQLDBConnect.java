package dal.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDBConnect {
	private static Connection con;
	
	private final static String drivename = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String dburl = "jdbc:sqlserver://localhost:1434; DatabaseName=FAMS";
	
	private final static String dbname = "sa";
	private final static String dbpwd = "123456";
	
	static {
		try {
			
			Class.forName(drivename); 
			con = DriverManager.getConnection(dburl, dbname, dbpwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static Connection getSQLDBConection(){
		return con;
	}
	
	public static void closeDB(){
		try {
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
