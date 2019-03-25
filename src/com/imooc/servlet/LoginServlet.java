package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//登陆模式
		LibServiceImpl service=new LibDaoImpl();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//检查用户名和密码是否正确
		if(service.login(username, password)==1) {
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", username);
			response.sendRedirect(request.getContextPath() + "/pages/admin/server.jsp?flag=1");
		}else {
			request.getRequestDispatcher("/index.jsp?flag=3").forward(request, response);
		}
	}

}
