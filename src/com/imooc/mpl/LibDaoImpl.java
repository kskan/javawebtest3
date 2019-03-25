package com.imooc.mpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.domain.Book;
import com.imooc.domain.User;

public class LibDaoImpl implements LibServiceImpl {
	private static final List<User> userDb=new ArrayList<User>();
	private static final List<Map<String, Object>> classify=new ArrayList<Map<String,Object>>();
	private static final List<Book> books=new ArrayList<Book>();
//	用户注册
	public void regist(User user) {
		userDb.add(user);
		
	}
//	用户登录
	public int login(String username, String password) {
		int flag=0;
		for(User user:userDb) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)) {
				flag=1;
			}
		}
		
		return flag;
		
	}
//	判断指定的用户名在数据库是否存在
	public int isUserExist(String username) {
		int flag=0;
		for(User user:userDb) {
			if(user.getUsername().equals(username)) {
				flag=1;
			}
		}
		return flag;
		
	}
//	添加图书分类
	public void addBookCatgory(Long id, String catgoryName, String description) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id",id);
		map.put("catgoryName",catgoryName);
		map.put("description",description);
		classify.add(map);
	}
//	获取所有图书分类
	public List<Map<String, Object>> getAllBookCatgory(){
		return classify;
		
	}
//    添加图书
	public void addBook(Book book){
		books.add(book);
		
	}
//    根据条件来查询书籍信息
	public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {
		if("".equals(bookID)&&"".equals(bookName)&&"".equals(catgoryName))
		return books;
		else {
			List<Book> findbooks=new ArrayList<Book>();
			for(Book getbook:books) {
				if(getbook.getBookid().equals(bookID)||getbook.getBookname().equals(bookName)||getbook.getClassification().equals(catgoryName)) {
					findbooks.add(getbook);
				}
			}
			return findbooks;
		}
	}
	

}
