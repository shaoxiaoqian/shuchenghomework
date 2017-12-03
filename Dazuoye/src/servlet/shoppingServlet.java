package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.book;
import beans.shopCart;
import service.shopCartUpdate;

/**
 * Servlet implementation class shoppingServlet
 */
@WebServlet("/shoppingServlet")
public class shoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public shoppingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
		String userName = request.getParameter("userName");
		userName = new String(userName.getBytes("iso8859-1"), "utf-8");
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		
		String bookName = request.getParameter("bookName");
		bookName = new String(bookName.getBytes("iso8859-1"), "utf-8");
		String bookPrice = request.getParameter("bookPrice");
		
		// ��ȡsession����
		HttpSession session = request.getSession();
		// ��ȡsession�д洢�Ĺ��ﳵ��Ϣ������bookList��
		ArrayList<shopCart> list = (ArrayList<shopCart>) session.getAttribute("list");
		// �жϹ��ﳵ�Ƿ�Ϊ��
		if (null == list) {
			list = new ArrayList<>();
		}
		shopCart shopcart = new shopCart();
		shopcart.setBookID(bookId);
		shopcart.setBookName(bookName);
		shopcart.setUsername(userName);
		shopcart.setBookPrice(bookPrice);
		list.add(shopcart);

		// ҳ����ת����Ʒ�б����
		shopCartUpdate shopcartUpdate = new shopCartUpdate();
		if (shopcartUpdate.update(userName, bookId, bookName, bookPrice)) {
			// ����session�еĹ��ﳵ����
			session.setAttribute("list", list);
			request.getSession().setAttribute("success", "��ӹ��ﳵ�ɹ�");
			request.getRequestDispatcher("shoppingSuccsess.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("success", "��ӹ��ﳵʧ��");
			request.getRequestDispatcher("shoppingFail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
