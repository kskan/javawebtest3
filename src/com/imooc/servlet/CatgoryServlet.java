package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class CatgoryServlet
 */
@WebServlet("/CatgoryServlet")
public class CatgoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatgoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//录入书的类别
		try {
		LibServiceImpl service=new LibDaoImpl();
		Long id=Long.parseLong(request.getParameter("id"));
		String catgoryName=request.getParameter("catgoryName");
		String description=request.getParameter("description");
		//检查是否留空
		if(id!=null&&catgoryName!=null&&description!=null&&!"".equals(catgoryName)&&!"".equals(description)) {
	    service.addBookCatgory(id, catgoryName, description);
		response.sendRedirect(request.getContextPath()+"/pages/admin/catgory.jsp?flag=1");
		}else {
		response.sendRedirect(request.getContextPath()+"/pages/admin/catgory.jsp?flag=2");
			
		}
		}catch(NumberFormatException e) {
			// TODO: handle exception
			//id号输入的不是数字的，报错
			response.sendRedirect(request.getContextPath()+"/pages/admin/catgory.jsp?flag=3");
		}
	}

}
