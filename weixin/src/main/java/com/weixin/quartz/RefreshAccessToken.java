package com.weixin.quartz;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.weixin.json.AccessToken;
import com.weixin.json.ErrorEntity;
import com.weixin.pojo.WeiXinContent;
import com.weixin.util.WeiXinFinallValue;

@Component
public class RefreshAccessToken {
public static final String at="ISUHwHIFXqCWcCSWuvENiysxoDsHKCR9ToLg3bPdBh9b3ktlfw9KuDEsETTLHTeyztKYbHbEj__UOGZW-zy_aZC9lBJc2JOHLGc76W_P5soAUHgADAFZM";
	public void refreshToken() {
		WeiXinContent.setAccessToken(at);
	/*	// System.out.println("refersh!"+new Date());
		HttpGet get = null;
		CloseableHttpClient client = null;
		CloseableHttpResponse cl = null;
		try {
			client = HttpClients.createDefault();
			String url = WeiXinFinallValue.ACCESS_TOKEN_URL;
			url = url.replace("APPID", WeiXinFinallValue.APPID);
			url = url.replace("APPSECRET", WeiXinFinallValue.APPSECRET);
			// System.out.println(url);
			get = new HttpGet(url);
			cl = client.execute(get);
			int stat = cl.getStatusLine().getStatusCode();
			// System.out.println(stat);
			if (stat >= 200 && stat < 300) {
				HttpEntity entity = cl.getEntity();
				String content = EntityUtils.toString(entity);
				// System.out.println(content);
				Gson gson = new Gson();
				try {
					AccessToken accessToken = gson.fromJson(content, AccessToken.class);
					//System.out.println("Access_token:" + accessToken.getAccess_token());
					//System.out.println("Expires_in:" + accessToken.getExpires_in());
					WeiXinContent.setAccessToken(accessToken.getAccess_token());
				} catch (Exception e) {
					ErrorEntity errorEntity=gson.fromJson(content, ErrorEntity.class);
					System.out.println("»ñÈ¡tokenÊ§°Ü£º"+errorEntity.getErrorcode()+","+errorEntity.getErrormessage());
				    refreshToken();
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				if (cl != null)
					cl.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}*/
	}

}
