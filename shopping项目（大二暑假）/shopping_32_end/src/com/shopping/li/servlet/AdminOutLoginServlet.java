/**
* @package_name   com.shopping.li.servlet
* @file_name AdminOutLoginServlet.java
* @author Administrator
* @date 2013-8-2
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @ClassName: AdminOutLoginServlet
 * @Description: TODO
 */
public class AdminOutLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");		

		request.getSession().setAttribute("admin", null);

		response.sendRedirect("login.jsp");
	}

}
