package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imooc.domain.Book;
import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class SelectBookServlet
 */
@WebServlet("/SelectBookServlet")
public class SelectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取所有的图书列表
		LibServiceImpl service=new LibDaoImpl();
		List<Book> books=service.getBooksByCondition("", "", "");
		HttpSession session=request.getSession();
		session.setAttribute("list", books);
		request.getRequestDispatcher("/pages/admin/showBook.jsp").forward(request, response);
		
	}

}
