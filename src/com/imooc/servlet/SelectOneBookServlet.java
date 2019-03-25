package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.imooc.domain.Book;
import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class SelectOneBookServlet
 */
@WebServlet("/SelectOneBookServlet")
public class SelectOneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取指定信息，搜索书籍并且以json的形式显示
		
		 String id=request.getParameter("bookID");
	     String name=request.getParameter("bookName");
	     String catgory=request.getParameter("catgoryName");
//	     System.out.println(id+name+catgory);
	     LibServiceImpl service=new LibDaoImpl();
	     
	     List<Book> getbook=service.getBooksByCondition(id, name, catgory);
	     String json = JSON.toJSONString(getbook);
//	     System.out.println(json);
	     response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().println(json);
	     
	     
	}

	
}
