/**
* @package_name   com.shopping.li.servlet
* @file_name FreezeUserServlet.java
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


import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;

/** 
 * @ClassName: FreezeUserServlet
 * @Description: TODO
 */
public class FreezeUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = UserServiceImpl.getInstance().getUserById(userId);
		if(user.getState()!=1){
			UserServiceImpl.getInstance().freezeUserById(userId,1);
		}else {
			UserServiceImpl.getInstance().freezeUserById(userId,0);
		}
		response.sendRedirect("MemberManage.jsp");
	}

}
