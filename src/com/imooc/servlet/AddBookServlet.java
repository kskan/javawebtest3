package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.Book;
import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//添加书
		LibServiceImpl service=new LibDaoImpl();
		String id=request.getParameter("id");
		String bookName=request.getParameter("bookName");
		String catgoryName=request.getParameter("catgoryName");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		//检查所有值是否留空
		if(!"".equals(id)&&!"".equals(bookName)&&!"".equals(catgoryName)&&!"".equals(price)&&!"".equals(description)) {
			//检查价格是否为负
			if(Integer.parseInt(price)>=0) {
			//添加书
			Book book=new Book(id,bookName,catgoryName,price,description);
//			System.out.println(book.toString());
			service.addBook(book);
			response.sendRedirect(request.getContextPath()+"/ToAddBookServlet?flag=1");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/ToAddBookServlet?flag=3");
				
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/ToAddBookServlet?flag=2");
		}

	}

}
