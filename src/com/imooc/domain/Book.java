package com.imooc.domain;

public class Book {
	private String bookid;
	private String bookname;
	private String classification;
	private String price;
	private String describe;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Book(String bookid, String bookname, String classification, String price, String describe) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.classification = classification;
		this.price = price;
		this.describe = describe;
	}
	public Book() {
		
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", classification=" + classification + ", price="
				+ price + ", describe=" + describe + "]";
	}
	
	
	

}
