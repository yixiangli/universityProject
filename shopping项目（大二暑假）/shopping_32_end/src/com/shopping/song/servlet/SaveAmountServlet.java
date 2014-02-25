package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveAmountServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        System.out.println("1234567");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
        
		String goodsId = request.getParameter("goodsId");
		String newAmount = request.getParameter("newAmount");
		
		try {			
			Cookie cookie = new Cookie(goodsId, newAmount);
			response.addCookie(cookie);
			out.print("修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("修改失败");
		}
		
		out.flush();
		out.close();
	}
	}


