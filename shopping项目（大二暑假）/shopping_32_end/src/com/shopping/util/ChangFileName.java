package com.shopping.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ChangFileName{
    public static String getFileName(){
    	String newFileName = new String();
    	
    	String nowTime = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
    	int num = new Random().nextInt(9999);
    	newFileName = nowTime+num;
    	return newFileName;
    }
    public static StringBuffer getClientIp(String cientIp){
    	String[] ip = cientIp.split(":");
    	StringBuffer str = new StringBuffer();
    	for(int i=0;i<ip.length;i++){
    		ip[i] = addZero(ip[i]);
    		str.append(ip[i]);
    	}
    	return str;
    }
    public static String addZero(String str){
    	if(str.length()<3){
			str = addZero("0"+str);
		}
    	return str;
    }
}
