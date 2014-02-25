package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCartServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			PrintWriter out = response.getWriter();

			String goodsId = request.getParameter("goodsId");
			System.out.println(goodsId);
			try {
				Cookie cookie = new Cookie(goodsId, null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				out.print("<font color=yellow>删除成功</font>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<font color=red>删除失败</font>");
			}
			out.flush();
			out.close();
		}

	}


