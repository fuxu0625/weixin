package com.weixin.dao;

import org.springframework.stereotype.Component;

import com.weixin.pojo.Book;

@Component
public class BookDao {
	 //ģ�����ݿ����  
    public void add(Book book){  
        System.out.print("Add");  
    }  
    public void update(Book book){  
        System.out.print("Update");  
    }  
}
