package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import dao.Dao;

public class shopCartUpdate {

public static boolean update(String username,String bookid,String bookName,String bookprice ) {
		
		Dao dao = new Dao();
		Connection connection = dao.getConn();
		//3.创建Statement对象,并执行响应sql语句，获取图书列表
		java.sql.PreparedStatement pre ;
		String sqlStr = "insert into shopCart values(null,?,?,?,?) ";
		
		
			
			 try {
				
				pre = connection.prepareStatement(sqlStr);
				pre.setString(1,username);
				pre.setString(2,bookid);
				pre.setString(3,bookName);
				pre.setString(4,bookprice);
				int i= pre.executeUpdate();
				
				if(i>0) {
					return true;
				}else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return false;
}
	
}
