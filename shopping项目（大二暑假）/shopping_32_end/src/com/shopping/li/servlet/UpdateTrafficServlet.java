package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;

public class UpdateTrafficServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			User user = (User)request.getSession().getAttribute("user");
			String username = user.getUsername();
		
			String realname = request.getParameter("realname");
			String address = request.getParameter("address");
			String area1 = request.getParameter("area1");
			String area2 = request.getParameter("area2");
			String area3 = request.getParameter("area3");
			
			String area = area1+""+area2+""+area3;
			
			String postcode = request.getParameter("postcode");
			String tel = request.getParameter("tel");
			
			UserServiceImpl.getInstance().updateInfo(username, realname, address, area, postcode, tel);
		
			User user2 = UserServiceImpl.getInstance().login(username, user.getPassword());
			request.getSession().setAttribute("user",user2);
	}

}
