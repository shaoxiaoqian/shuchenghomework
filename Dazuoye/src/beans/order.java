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
				//��ȡ��ǰ�м�¼����װ��һ��Book����
				int id = rs.getInt("id");
				String bookid = rs.getString("bookId");
				String username = rs.getString("username");
				String bookname = rs.getString("bookName");
				
				String price = rs.getString("bookPrice");
				
				//�û�ȡ�������ݴ���Book����
				shopCart order = new shopCart();
				order.setId(id);
				order.setBookID(bookid);
				order.setUsername(username);
				order.setBookName(bookname);
				order.setBookPrice(price);
				//��book������ӵ���Ʒ�б���
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
