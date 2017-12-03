package beans;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DatabaseConn;
import beans.book;


public class Cart {
	private List<book> list = null;

	/**
	 * 从Modal层获取商品信息(ResultSet)，
	 * 转换成ArrayList集合
	 * @author lww
	 *
	 */
	public List<book> getGoodsList(){
		ResultSet rs = DatabaseConn.getBooksList();
		 list = new ArrayList<>();
		try {
			while(rs.next()) {
				//获取当前行记录并包装成一个Book对象
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				//用获取到的数据创建Book对象
				book book = new book();
				book.setBookId(id);
				book.setBookName(name);
				book.setBookPrice(price);
				//把book对象添加到商品列表中
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
