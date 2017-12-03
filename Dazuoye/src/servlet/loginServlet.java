package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cart;
import service.CegUserService;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso8859-1"),"utf-8");
		String password = request.getParameter("password");
		CegUserService ceguserservice = new CegUserService();
		if(ceguserservice.loginCheck(username, password)) {
			request.getSession().setAttribute("username", username);
			
			Cart cart=new Cart();
			request.getSession().setAttribute("book", cart.getGoodsList());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			
			out.print("<h1>用户名不存在，<a href='regist.html'>去注册</a><h1>");
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
