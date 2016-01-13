package com.weixin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.omg.PortableServer.ServantActivator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weixin.pojo.WeiXinContent;
import com.weixin.util.SecurityKit;

@Controller
public class WeiXinController {
	public static final String TOKEN = "fuxu";

	@RequestMapping(value="/wget",method=RequestMethod.GET)
	public void init(HttpServletRequest req, HttpServletResponse resq) throws IOException {
		// signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		// timestamp 时间戳
		// nonce 随机数
		// echostr 随机字符串
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		String[] arrs = { WeiXinController.TOKEN, nonce, timestamp };
		Arrays.sort(arrs);
		StringBuffer sBuffer = new StringBuffer();
		for (String string : arrs) {
			sBuffer.append(string);
		}
		String sha1 = SecurityKit.sha1(sBuffer.toString());
		System.out.println(sha1.equals(signature));
		if (sha1.equals(signature)) {
			resq.getWriter().println(echostr);
		}

	}
	/**
	 * 接受微信返回的消息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/wget",method=RequestMethod.POST)
    public void getInfo(HttpServletRequest request,HttpServletResponse response){
    	try {
			BufferedReader bReader=new BufferedReader(new InputStreamReader(request.getInputStream()));
		    String string=null;
		     while ((string=bReader.readLine())!=null) {
				System.out.println(string);
				
			}
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	@RequestMapping("/act")
	public void testAccessToken(HttpServletResponse resq) throws IOException {
		resq.getWriter().println(WeiXinContent.getAccessToken());
	}
}
