/**
* @package_name   com.shopping.li.servlet
* @file_name CheckCaptchaServlet.java
* @author Administrator
* @date 2013-8-20
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @ClassName: CheckCaptchaServlet
 * @Description: TODO
 */
public class CheckCaptchaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String inputCaptcha = request.getParameter("inputCaptcha");
		String captcha = (String)request.getSession().getAttribute("captcha");
		if(inputCaptcha.equals(captcha)) {
			out.print("<font color=green>验证码正确!</font>");
		} else {
			out.print("<font color=red>验证码不正确!</font>");
		}
		
		out.flush();
		out.close();
	}

}
