package com.weixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weixin.dao.BookDao;
import com.weixin.pojo.Book;
@Component
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	 public void add(Book book){  
	        bookDao.add(book);  
	    }  
	    public void update(Book book){  
	        bookDao.update(book);  
	    }  

}
