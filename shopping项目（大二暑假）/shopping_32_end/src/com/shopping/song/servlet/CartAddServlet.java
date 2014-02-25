package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class CartAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String gid = request.getParameter("gid");
		
		int num = 1;
		//System.out.println(num);
		try {
			Cookie[] cookies = request.getCookies();
			//System.out.println(cookies.length);
			for(int i=1;i<cookies.length;i++) {
				
				if(cookies[i].getName().equals(gid)){
					num += Integer.parseInt(cookies[i].getValue());
					//System.out.println(num+"5555555555555");
				}
			}
			Cookie cookie = new Cookie(gid, num+"");
			//System.out.println(cookies.length);
			//cookie.setMaxAge(100000);
			
			response.addCookie(cookie);
			//System.out.println(num+"888888888");
			
			String gName = GoodsServiceImpl.getInstance().showGoodsById(Integer.parseInt(gid)).getGname();
			out.print("1个"+gName+"成功加入，现在已有"+num+"个");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("加入购物车失败！");
		}
		out.flush();
		out.close();
	}

}
