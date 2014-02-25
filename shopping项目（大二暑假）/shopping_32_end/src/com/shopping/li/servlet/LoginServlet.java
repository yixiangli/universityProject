package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.li.exception.DongJieException;
import com.shopping.li.exception.PasswordErrorException;
import com.shopping.li.exception.UserNotFoundException;
import com.shopping.li.service.impl.UserServiceImpl;
import com.shopping.po.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//AJAX��������
		//��Ҫ����������ٻ���
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
							
		//������������
		response.setDateHeader("Expires", 0);
							
		//��Ҫ��������������
		response.setHeader("Pragma","no-cache");
			
		//1.����URL����
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
			
		//2.����ҵ���߼�
		
		
		response.setCharacterEncoding("UTF-8");
		//�����д��ȥ
		PrintWriter out = response.getWriter();
	
		try{
			
			User user = UserServiceImpl.getInstance().login(username, password);
				
			out.print("登陆成功");
			//session
			request.getSession().setAttribute("user", user);
			
		} catch (UserNotFoundException e) {

			out.print("用户名不存在");
		} catch (PasswordErrorException e)  {

			out.print("密码错误");
			
		}	catch(DongJieException e){
			
			out.print("您的账户已被冻结");
		}	
		out.flush();
		out.close();
	}
	
}
