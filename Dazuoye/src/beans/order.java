package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import service.shopCartSelect;

public class order {
	private List<shopCart> list = null;
	public List<shopCart> getGoodsList(){
		ResultSet rs = shopCartSelect.getShopCartList();
		 list = new ArrayList<>();
		try {
			while(rs.next()) {
				//获取当前行记录并包装成一个Book对象
				int id = rs.getInt("id");
				String bookid = rs.getString("bookId");
				String username = rs.getString("username");
				String bookname = rs.getString("bookName");
				
				String price = rs.getString("bookPrice");
				
				//用获取到的数据创建Book对象
				shopCart order = new shopCart();
				order.setId(id);
				order.setBookID(bookid);
				order.setUsername(username);
				order.setBookName(bookname);
				order.setBookPrice(price);
				//把book对象添加到商品列表中
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
