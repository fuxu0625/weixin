package com.weixin.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.Gson;
import com.sun.security.ntlm.Client;
import com.weixin.pojo.WeixinMenu;
import com.weixin.quartz.RefreshAccessToken;
import com.weixin.util.WeiXinFinallValue;

public class TestMenu {
	@Test
	public void testMenu() throws ClientProtocolException, IOException {
		List<WeixinMenu> list=new ArrayList<WeixinMenu>();
		WeixinMenu menu=new WeixinMenu();
		menu.setId(1);
		menu.setName("学习网站");
		menu.setType("view");
		menu.setUrl("http://www.baidu.com");
		list.add(menu);
		WeixinMenu menu2=new WeixinMenu();
		menu2.setName("资源测试");
		List<WeixinMenu> menu2sub=new ArrayList<WeixinMenu>();
		menu=new WeixinMenu();
		menu.setId(2);
		menu.setName("事件");
		menu.setType("click");
		menu.setKey("a001");
		menu2sub.add(menu);
		menu=new WeixinMenu();
		menu.setId(3);
		menu.setName("扫码带提示");
		menu.setType("scancode_waitmsg");
		menu.setKey("rselfmenu_0_0");
		menu2sub.add(menu);
		menu2.setSub_button(menu2sub);
		list.add(menu2);
		Map<String, List<WeixinMenu>> map=new HashMap<String, List<WeixinMenu>>();
		map.put("button", list);
		Gson gson=new Gson();
		//System.out.println(gson.toJson(map));
		String json=gson.toJson(map);
		
		CloseableHttpClient closeableHttpClient=HttpClients.createDefault();
		String url=WeiXinFinallValue.MENU_ADD;
		url=url.replace("ACCESS_TOKEN", RefreshAccessToken.at);
		HttpPost post=new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		StringEntity entity=new StringEntity(json,ContentType.create("application/json","utf-8"));
		post.setEntity(entity);
		CloseableHttpResponse resp=closeableHttpClient.execute(post);
		int state=resp.getStatusLine().getStatusCode();
		System.out.println(EntityUtils.toString(resp.getEntity()));
		if (state>=200&&state<300) {
			System.out.println(EntityUtils.toString(resp.getEntity()));
		}
		
	}

}
