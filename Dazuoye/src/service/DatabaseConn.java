package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.Dao;

public class DatabaseConn {
	public static ResultSet getBooksList() {
		
		Dao dao = new Dao();
		Connection connection = dao.getConn();
		//3.����Statement����,��ִ����Ӧsql��䣬��ȡͼ���б�
		Statement statement;
		try {
			statement = connection.createStatement();
			String sqlStr = "select id,name,price from book";
			ResultSet booksListRS = statement.executeQuery(sqlStr);
			return booksListRS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
		
	
	
	

