package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.exception.PasswordDifferentException;
import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;

public class UpdatePwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
			
		PrintWriter out = response.getWriter();
	
		//1.����URL
		User user = (User)request.getSession().getAttribute("user");
		String username = user.getUsername();
		
		String oldPwd = request.getParameter("oldpwd");
		String newPwd = request.getParameter("newpwd");
		
		//����ҵ���߼�
		
		try {
			
			UserServiceImpl.getInstance().updatePassword(username,oldPwd,newPwd);
			out.print("修改成功，请牢记新密码");
			
		} catch (PasswordDifferentException e) {
			
			out.print("原始密码不正确");
			// TODO: handle exception
		}
	}
}
