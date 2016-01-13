package com.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weixin.pojo.Book;
import com.weixin.service.BookService;

@Controller
@RequestMapping("/book/")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "add")
	@ResponseBody
	public String add(Book book) {
		System.out.println("bookname:" + book.getName());
		System.out.println("author:" + book.getAuthor());
		bookService.add(book);
		return "success";
	}

}
