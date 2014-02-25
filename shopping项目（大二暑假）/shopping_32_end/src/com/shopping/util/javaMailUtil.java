package com.shopping.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

 
 
 

/**
 * 使用Gmail发送邮件
 * 
 * @author Winter Lau
 */
public class javaMailUtil {
	
	private static Properties props = null;
	private static Session session = null;
	private static Message msg = null;
    
	private static void setProperties(String mailType,String mailPort){	
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		props = System.getProperties();
		props.setProperty("mail.smtp.host", mailType);
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", mailPort);
		props.setProperty("mail.smtp.socketFactory.port",mailPort);
		props.put("mail.smtp.auth", "true");		
	}
	
	private static void getSessionInstance(final String userName,final String password){	
		session = Session.getDefaultInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName, password);
					}
				});
	}
	
	public static void setMessage(String toMail,String userName) throws AddressException, MessagingException{
		msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail, false));
		msg.setSubject("小强强");
		msg.setText("How are you");
		msg.setSentDate(new Date());
	}
	
	public static void setHtmlMessage(String toMail,String userName,String content) throws AddressException, MessagingException{
		
		Multipart mp = new MimeMultipart();
        MimeBodyPart mbp = new MimeBodyPart();   
        // 设定邮件内容的类型为 text/plain 或 text/html   
        mbp.setContent(content,"text/html;charset=GB2312");   
        mp.addBodyPart(mbp);  
        
        msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail, false));
		msg.setSubject("奋斗电子商城欢迎你！");
		msg.setContent(mp); 
		msg.setSentDate(new Date());
	}
	
	private static String getMailContent(String htmlPath) throws IOException{
		String content = "";
		String temp = "";
		BufferedReader br = null;
		InputStreamReader fr = new InputStreamReader(new FileInputStream(htmlPath),"gb2312");
        br = new BufferedReader(fr);
        while ((temp=br.readLine()) != null){
        	content = content + temp;
        }
		return content;
	}
	private static void sendSingleMail(String mailType,String mailPort,String userName,String password,String toMail,String htmlPath) throws MessagingException, IOException{	
		
		setProperties(mailType,mailPort);//设置邮件类型和邮件端口
		getSessionInstance(userName,password);//获取邮件session实例
		//setMessage(toMail,userName);//设置邮件的内容
		setHtmlMessage(toMail,userName,getMailContent(htmlPath));
		Transport.send(msg);//发送邮件消息
		
	}
	
	public static void sendMultiMails(String mailType,String mailPort,String userName,String password,String[] toClientMails,String htmlPath)throws MessagingException, IOException{
		for (int i = 0; i < toClientMails.length; i++) {
			sendSingleMail(mailType,mailPort,userName,password,toClientMails[i],htmlPath);
		}
	}
	
	 
	public static void SetMail() throws AddressException,
			MessagingException, IOException {
		javaMailUtil test = new javaMailUtil();
		String[] toClientMails = {"394244674@qq.com"}; 
		//test.sendSingleMail("smtp.gmail.com", "465","laihuiqiang11@gmail.com","ruanjian11","346423152@qq.com","e:\\ApplicantNotAssess.txt");
		test.sendMultiMails("smtp.gmail.com","465","laihuiqiang11@gmail.com","ruanjian11",toClientMails,"e:\\shoppingMail.txt");
	}
}