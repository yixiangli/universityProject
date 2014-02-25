package com.shopping.util;

import java.io.IOException;
import java.util.Properties;


public class PropUtil {
	
	  //�������һ���ԵĻ�ȡ��һ��properties�����ļ��е����е���Ϣ
	  public static Properties getProp(String fileName){
		  Properties prop = new Properties();
		  try {
			prop.load(PropUtil.class.getClassLoader().getResourceAsStream(fileName));
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			prop = null;
		  }
		  
		  return prop;
	  }
	  
	  
	//�������ͨ��name�õ�һ��properties�����ļ��е�һ��value
	  public static String getValue(String fileName,String name){
		  String value = null;
		  Properties prop = new Properties();
		  try {
			prop.load(PropUtil.class.getClassLoader().getResourceAsStream(fileName));
		    value = prop.getProperty(name);
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  return value;
	  }
	  
}
