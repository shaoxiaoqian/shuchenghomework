package service;

import java.sql.*;

import dao.Dao;

public class CegUserService {
	/*import dao.Dao;

	import java.sql.*;

	
	public class CegUserService {
	    public ResultSet resultSet = null;
	    //µÇÂ¼ÑéÖ¤
	    public boolean loginCheck(String username,String password) throws SQLException {
	        Dao dao = new Dao();
	        Connection connection = dao.getConn();
	        PreparedStatement preparedStatement;
	        String sql = "select userpassword from ceg_user where username = ?";
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1,username);
	        resultSet = preparedStatement.executeQuery();
	        if(resultSet.next()){
	            if(password.equals(resultSet.getString("userpassword"))){
	                preparedStatement.close();
	                connection.close();
	                resultSet.close();
	                return true;
	            }else{
	                preparedStatement.close();
	                connection.close();
	                resultSet.close();
	                return false;
	            }

	        }
	        return false;
	    }
	   */
public ResultSet resultSet = null;
public boolean loginCheck(String username, String password) {
	Dao dao = new Dao();
	Connection connection = dao.getConn();
	PreparedStatement preparedStatement;
	String sql = "select password from ceg_user where name=?";
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			if(password.equals(resultSet.getString("password"))) {
				preparedStatement.close();
				connection.close();
				resultSet.close();
				return true;
				
				
			}else{
				preparedStatement.close();
				connection.close();
				resultSet.close();
				return false;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
public boolean signUp(String name,String password ,String email) {
	Dao dao = new Dao();
	Connection connection = dao.getConn();
	PreparedStatement preparedStatement ;
	String sql = "insert into ceg_user values(null,?,?,?)";
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, email);
		int i = preparedStatement.executeUpdate();
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
