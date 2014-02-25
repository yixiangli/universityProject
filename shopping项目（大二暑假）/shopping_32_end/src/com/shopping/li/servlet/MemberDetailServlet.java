/**
* @package_name   com.shopping.li.servlet
* @file_name MemberDetailServlet.java
* @author Administrator
* @date 2013-7-25
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.impl.AdminServiceImpl;
import com.shopping.po.User;

/** 
 * @ClassName: MemberDetailServlet
 * @Description: TODO
 */
public class MemberDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
	
		User user = AdminServiceImpl.getInstance().showUserByUsername(username);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("manage/memberDetail.jsp").forward(request, response);
		/*out.flush();
		out.close();*/
	}

}
