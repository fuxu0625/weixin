package com.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/abc")
	public ModelAndView test() {
		System.out.println("��ã�spring MVC������ô���ӣ�");
		return new ModelAndView("jsp/test");
	}
}
