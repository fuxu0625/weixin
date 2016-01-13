package com.weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityKit {

	public static String sha1(String string){
		StringBuffer stringBuffer = new StringBuffer();
		MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("sha1");
			mDigest.update(string.getBytes());
			byte[] msg = mDigest.digest();
	         for(byte b:msg){
	        	 //System.out.println(b);
	        	 stringBuffer.append(String.format("%02x", b));
	         }
			return stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	

	}
}
