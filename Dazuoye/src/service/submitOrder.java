package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Dao;

public class submitOrder {
public static boolean insert( ) {
		
		Dao dao = new Dao();
		Connection connection = dao.getConn();
		//3.����Statement����,��ִ����Ӧsql��䣬��ȡͼ���б�
		java.sql.PreparedStatement pre ;
		String sqlStr = "INSERT INTO userorder SELECT * FROM shopcart";
		
		
			
			 try {
				
				pre = connection.prepareStatement(sqlStr);
				
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
