package com.weixin.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeiXinQuartzJob {
	@Autowired
	private RefreshAccessToken refreshAccessToken;

	// @Scheduled(cron = "0/5 * * * * ? ")
	 public void task() {
	 refreshAccessToken.refreshToken();
	 // System.out.println("sdad");
	 }

}
