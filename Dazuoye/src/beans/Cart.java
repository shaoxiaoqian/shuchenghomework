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
	 * ��Modal���ȡ��Ʒ��Ϣ(ResultSet)��
	 * ת����ArrayList����
	 * @author lww
	 *
	 */
	public List<book> getGoodsList(){
		ResultSet rs = DatabaseConn.getBooksList();
		 list = new ArrayList<>();
		try {
			while(rs.next()) {
				//��ȡ��ǰ�м�¼����װ��һ��Book����
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				//�û�ȡ�������ݴ���Book����
				book book = new book();
				book.setBookId(id);
				book.setBookName(name);
				book.setBookPrice(price);
				//��book������ӵ���Ʒ�б���
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
