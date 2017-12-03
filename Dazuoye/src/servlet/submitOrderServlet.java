package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.shopCart;
import service.ClearShopcart;
import service.shopCartUpdate;
import service.submitOrder;

/**
 * Servlet implementation class submitOrderServlet
 */
@WebServlet("/submitOrderServlet")
public class submitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		if (submitOrder.insert()) {
			ClearShopcart Clear = new ClearShopcart();
			Clear.delete();
			request.getSession().setAttribute("success", "提交订单成功");
			
			request.getRequestDispatcher("submitOrderSuccess.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("success", "提交订单失败");
			request.getRequestDispatcher("submitOrderFail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
