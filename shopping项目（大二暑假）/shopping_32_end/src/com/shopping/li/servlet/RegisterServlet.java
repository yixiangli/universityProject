package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���봦��
		response.setCharacterEncoding("utf-8");
		//1.����URL����
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String realname = request.getParameter("realname");
		String address = request.getParameter("address");
		String area1 = request.getParameter("area1");
		String area2 = request.getParameter("area2");
		String area3 = request.getParameter("area3");
		String postcode = request.getParameter("postcode");
		String tel = request.getParameter("tel");
		
		String area = area1+""+area2+""+area3;
		//2.����ҵ���߼�
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setRealname(realname);
		user.setAddress(address);
		user.setArea(area);
		user.setPostcode(postcode);
		user.setTel(tel);
		
		UserServiceImpl.getInstance().register(user);
		
		
		//3.��ת
	
		
		
		
	}

}
