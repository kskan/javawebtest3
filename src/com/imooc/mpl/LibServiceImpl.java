package com.imooc.mpl;

import java.util.List;
import java.util.Map;

import com.imooc.domain.Book;
import com.imooc.domain.User;

public interface LibServiceImpl {
	public void regist(User user);
	public int login(String username, String password);
	public int isUserExist(String username);
	public void addBookCatgory(Long id, String catgoryName, String description);
	public List<Map<String, Object>> getAllBookCatgory();
	public void addBook(Book book);
	public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName);
	
	
	

}
