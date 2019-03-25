package com.imooc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.domain.User;
import com.imooc.mpl.LibDaoImpl;
import com.imooc.mpl.LibServiceImpl;

/**
 * Servlet implementation class ToAddBookServlet
 */
@WebServlet("/ToAddBookServlet")
public class ToAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibServiceImpl service=new LibDaoImpl(); 
		List<Map<String, Object>> listmap=service.getAllBookCatgory();
		List<String> catgoryName=new ArrayList<String>();
		for(Map map:listmap) {
//			System.out.println(map.get("catgoryName"));
			catgoryName.add((String)map.get("catgoryName"));
		}
		request.setAttribute("catgoryName", catgoryName);
		request.getRequestDispatcher("/pages/admin/addBook.jsp").forward(request, response);
		
	}

}
