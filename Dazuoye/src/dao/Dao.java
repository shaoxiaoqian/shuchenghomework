package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
public Connection conn;
public Connection getConn() {
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/frist?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	String username="root";
	String password="253044";
	conn=null;
	
		try {
			Class.forName(driver);
			try {
                conn = DriverManager.getConnection(url,username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	return conn;
}
public void close() {
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
