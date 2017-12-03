package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.Dao;

public class shopcartDelete {
	public boolean delete(String id) {
		Dao dao = new Dao();
		Connection conn = dao.getConn();
		PreparedStatement preparedStatement;
		String sql = "delete from shopcart where id = ?";
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			int i = preparedStatement.executeUpdate();
			
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		}

}
