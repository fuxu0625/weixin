package com.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class MessageUtil {
	/**
	 * xml  to  map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map= new HashMap<String, String>();
	    SAXReader reader=new SAXReader();
	    InputStream inputStream=request.getInputStream();
	    Document document=reader.read(inputStream);
	    Element root=document.getRootElement();
	    List<Element> list=root.elements();
	    for(Element a:list){
	    	map.put(a.getName(), a.getText());
	    	
	    }
	    inputStream.close();
	    return map;
	}

}
