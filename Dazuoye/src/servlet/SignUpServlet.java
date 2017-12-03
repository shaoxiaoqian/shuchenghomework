package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CegUserService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
 	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		String repassword = request.getParameter("repeat");
		CegUserService ceguserservice = new CegUserService();
		if(password.equals(repassword)) {
		if(ceguserservice.signUp(username,password,email)) {
			out.print("<h1>×¢²á³É¹¦£¬<a href='regist.html'>È¥µÇÂ½</a><h1>");
			
		}else {
			request.getSession().setAttribute("error","×¢²áÊ§°Ü");
            request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
		}else {
			request.getSession().setAttribute("error","ÃÜÂë²»Ò»ÖÂ");
            request.getRequestDispatcher("error.jsp").forward(request,response);
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
