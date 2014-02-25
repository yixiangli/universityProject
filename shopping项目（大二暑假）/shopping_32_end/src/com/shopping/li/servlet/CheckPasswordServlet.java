/**
* @package_name   com.shopping.li.servlet
* @file_name CheckPasswordServlet.java
* @author Administrator
* @date 2013-8-19
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @ClassName: CheckPasswordServlet
 * @Description: TODO
 */
public class CheckPasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setCharacterEncoding("utf-8");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		PrintWriter out = response.getWriter();
		if(!password1.equals(password2)){			
			out.print("<font color='red'>前后密码不一致!</font>");	
		}
		if(password1==""&&password2==""){
			out.print("<font color='red'>请输入密码!</font>");	
		}
		if(password1!=""&&password2==""){
			out.print("<font color='red'>请确认输入!</font>");	
		}
		out.flush();
		out.close();
	}

}
