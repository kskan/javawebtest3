package com.imooc.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注册
		LibServiceImpl service=new LibDaoImpl();
		//1.判定输入格式是否符合表达式，并且查找用户名是否存在
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String checkPWD=request.getParameter("checkPWD");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		//接收错误信息
		String message=""; 
		//请输入正确邮箱格式
		if(!email.matches("[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+"))message="邮箱设置不正确";
		//请输入正确的手机号码格式
		if(!phone.matches("[1][3578][0-9]{9}"))message="手机号码输入不正确";
		//与上面是否重复
		if(!checkPWD.equals(password))message="前后密码不一致";
		//密码长度为6-12位的纯数字
	    if(!password.matches("[0-9]{6,12}"))message="密码输入不正确";
		//用户名是否重复
		if(service.isUserExist(username)==1)message="用户名已经存在";
		//用户名为3-12位字母数字或下划线组合
	    if(!username.matches("[a-zA-Z_]{3,12}"))message="用户名输入不正确";
		//2.检查是否有错误信息，如果有，发送错误信息，没有则注册
	    if("".equals(message)) {
		User regist=new User(username, password,phone, email);
		service.regist(regist);
		System.out.println(username+","+password+","+checkPWD+","+phone+","+email);
		 request.getRequestDispatcher("/index.jsp?flag=2").forward(request, response);
		}
		else {
			request.setAttribute("message", message);
			request.setAttribute("wrong", "1");
			request.getRequestDispatcher("/pages/admin/regist.jsp").forward(request, response);
		}
}

}
