/**
* @package_name   com.shopping.li.servlet
* @file_name ShowCommentServlet.java
* @author Administrator
* @date 2013-8-3
*/
package com.shopping.li.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.impl.UserServiceImpl;

/** 
 * @ClassName: ShowCommentServlet
 * @Description: TODO
 */
public class ShowCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
			
		String uidString  = request.getParameter("uid");	
		String gidString  = request.getParameter("gid");
		
		if(uidString!=null&&gidString!=null){
			int uid = Integer.parseInt(uidString);
			int gid = Integer.parseInt(gidString);
			
			String comment = UserServiceImpl.getInstance().showComment(uid, gid);
						
			if(comment==null){
				
				request.setAttribute("comment", "无");
				
			}else{
				
				request.setAttribute("comment", comment);
				
			}			
		}
		request.getRequestDispatcher("goods_detail.jsp").forward(request, response);		
	}
}
