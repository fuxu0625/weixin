package com.weixin.pojo;

public class WeiXinContent {
     private static String accessToken;

	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		WeiXinContent.accessToken = accessToken;
	}
     
}
