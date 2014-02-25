/**
* @package_name   com.shopping.li.servlet
* @file_name CommentServlet.java
* @author Administrator
* @date 2013-8-3
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.dao.impl.UserDao4MySqlImpl;
import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;

/** 
 * @ClassName: CommentServlet
 * @Description: TODO
 */
public class CommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String comment = request.getParameter("content");
		int uid = Integer.parseInt(request.getParameter("uid"));
		int gid = Integer.parseInt(request.getParameter("gid"));
		
		User user = (User)request.getSession().getAttribute("user");
			
		UserServiceImpl.getInstance().commentGoods(uid,gid,comment);
		out.print("评论成功");
		
		out.flush();
		out.close();
	}

}
