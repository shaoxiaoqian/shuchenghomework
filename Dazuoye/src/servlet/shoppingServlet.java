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
		
		// 获取session对象
		HttpSession session = request.getSession();
		// 获取session中存储的购物车信息参数（bookList）
		ArrayList<shopCart> list = (ArrayList<shopCart>) session.getAttribute("list");
		// 判断购物车是否为空
		if (null == list) {
			list = new ArrayList<>();
		}
		shopCart shopcart = new shopCart();
		shopcart.setBookID(bookId);
		shopcart.setBookName(bookName);
		shopcart.setUsername(userName);
		shopcart.setBookPrice(bookPrice);
		list.add(shopcart);

		// 页面跳转会商品列表界面
		shopCartUpdate shopcartUpdate = new shopCartUpdate();
		if (shopcartUpdate.update(userName, bookId, bookName, bookPrice)) {
			// 更新session中的购物车参数
			session.setAttribute("list", list);
			request.getSession().setAttribute("success", "添加购物车成功");
			request.getRequestDispatcher("shoppingSuccsess.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("success", "添加购物车失败");
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
