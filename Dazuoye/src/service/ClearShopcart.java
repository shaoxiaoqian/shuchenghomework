package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Dao;

public class ClearShopcart {
public static boolean delete( ) {
		
		Dao dao = new Dao();
		Connection connection = dao.getConn();
		//3.����Statement����,��ִ����Ӧsql��䣬��ȡͼ���б�
		java.sql.PreparedStatement pre ;
		String sqlStr = "delete from shopcart ";
		
		
			
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
