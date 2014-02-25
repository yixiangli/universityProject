/**
* @package_name   com.shopping.li.servlet
* @file_name MailServlet.java
* @author Administrator
* @date 2013-8-19
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.util.javaMailUtil;

/** 
 * @ClassName: MailServlet
 * @Description: TODO
 */
public class MailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			javaMailUtil.SetMail();
			out.print("邮件发送成功，请注意查收！");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			out.flush();
			out.close();
		}
	}

}
