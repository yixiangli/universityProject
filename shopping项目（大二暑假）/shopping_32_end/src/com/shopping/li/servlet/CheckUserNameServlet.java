/**
* @package_name   com.shopping.li.servlet
* @file_name CheckUserNameServlet.java
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

import com.shopping.li.service.UserService;
import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;


/** 
 * @ClassName: CheckUserNameServlet
 * @Description: TODO
 */
public class CheckUserNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = UserServiceImpl.getInstance();
		//拿到out输出
		PrintWriter out = response.getWriter();
		//接受参数
		String inputUsername = request.getParameter("name");
		User user = null;
		user = userService.getUserByUsername(inputUsername);
		if (inputUsername != "") {
			if (user == null) {
				out.print("<font color='green'>用户名已通过检测</font>");
			} else {
				// 通过out.print(String)给回调函数传参
				out.print("<font color='red'>用户名已存在，请重新输入!</font>");
			}
		}
		out.flush();
		out.close();
	}

}
