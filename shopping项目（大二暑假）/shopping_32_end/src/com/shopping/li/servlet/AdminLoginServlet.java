/**
* @package_name   com.shopping.li.servlet
* @file_name AdminLoginServlet.java
* @author Administrator
* @date 2013-7-23
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.exception.PasswordErrorException;
import com.shopping.li.exception.UserNotFoundException;
import com.shopping.li.service.impl.AdminServiceImpl;
import com.shopping.po.Admin;

/** 
 * @ClassName: AdminLoginServlet
 * @Description: TODO
 */
public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("admin");
		String password = request.getParameter("pwd");

		try {
			
			Admin admin = AdminServiceImpl.getInstance().login(username, password);
			request.getSession().setAttribute("admin", admin);
			out.print("登陆成功");
		} catch (UserNotFoundException e) {
			// TODO: handle exception
			out.print("用户不存在");
		} catch (PasswordErrorException e) {
			// TODO: handle exception
			out.print("密码错误");
		} 
		
		out.flush();
		out.close();
	}

}
