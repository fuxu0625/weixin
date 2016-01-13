package com.weixin.test;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public TestTimer(int second) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 0, second * 1000);
	}

	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("test timeTask");
		}
	}

	public static void main(String[] args) {
		new TestTimer(2);
	}
}
