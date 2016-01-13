package com.weixin.test;

import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.converter.json.GsonBuilderUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weixin.json.AccessToken;
import com.weixin.util.SecurityKit;
import com.weixin.util.WeiXinFinallValue;

public class TestWei {
	@Test
	public void testSha1() throws NoSuchAlgorithmException {

		String aString = SecurityKit.sha1("hello");
		// byte a = -10;
		// System.out.println(Integer.toHexString(a));
		// System.out.println(String.format("%02x", a));
		System.out.println(aString);

	}

	@Test
	public void testHttpClient(){
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			String url=WeiXinFinallValue.ACCESS_TOKEN_URL;
			url=url.replace("APPID", WeiXinFinallValue.APPID);
			url=url.replace("APPSECRET", WeiXinFinallValue.APPSECRET);
			//System.out.println(url);
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse cl = client.execute(get);
			int stat = cl.getStatusLine().getStatusCode();
			//System.out.println(stat);
			if (stat >=200&&stat <300) {
				HttpEntity entity=cl.getEntity();
				String content=EntityUtils.toString(entity);
				//System.out.println(content);
				Gson gson=new Gson();
				AccessToken accessToken=gson.fromJson(content, AccessToken.class);
				System.out.println("Access_token:"+accessToken.getAccess_token());
				System.out.println("Expires_in:"+accessToken.getExpires_in());
			}
		} catch (Exception e) {
		}
	}
}
