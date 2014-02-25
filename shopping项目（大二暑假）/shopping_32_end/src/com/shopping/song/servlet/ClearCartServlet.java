package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		Cookie[] cookies = request.getCookies();
		
		if(cookies.length>1) {
			for (int i = 1; i < cookies.length; i++) {
				cookies[i].setValue(null);
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
			PrintWriter out = response.getWriter();
			out.print("清空购物车成功");
			out.flush();
			out.close();
		}
		
	}


}
