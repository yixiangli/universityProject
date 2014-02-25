/**
* @package_name   com.shopping.li.servlet
* @file_name MemberManageServlet.java
* @author Administrator
* @date 2013-7-24
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.AdminService;
import com.shopping.li.service.impl.AdminServiceImpl;
import com.shopping.po.User;

/** 
 * @ClassName: MemberManageServlet
 * @Description: TODO
 */
public class MemberManageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		
		List<User> users = AdminServiceImpl.getInstance().showUsers();
		
		request.setAttribute("users",users);
		
		request.getRequestDispatcher("manage/MemberManage.jsp").forward(request, response);
	}

}
