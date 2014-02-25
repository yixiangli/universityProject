/**
* @package_name   com.shopping.li.servlet
* @file_name ShowAllCommentServlet.java
* @author Administrator
* @date 2013-8-3
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.UserGoods;

/** 
 * @ClassName: ShowAllCommentServlet
 * @Description: TODO
 */
public class ShowAllCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String gidString  = request.getParameter("gid");

		if(gidString!=null){
			int gid = Integer.parseInt(gidString);
			
			List<UserGoods> list = new ArrayList<UserGoods>();
			list = UserServiceImpl.getInstance().showAllComment(gid);
						
			request.setAttribute("userGoods", list);
			
		}
			
		request.getRequestDispatcher("goods_detail.jsp").forward(request, response);
	}

}
