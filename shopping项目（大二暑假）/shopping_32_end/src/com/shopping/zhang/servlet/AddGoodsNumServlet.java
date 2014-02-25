package com.shopping.zhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class AddGoodsNumServlet extends HttpServlet {
	private static final long serialVersionUID = -6713641068042628727L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		int num = Integer.parseInt(request.getParameter("num"));
		GoodsServiceImpl.getInstance().saveGoods(gid,num);
	
		PrintWriter out = response.getWriter();
		out.print("更新成功");
		out.flush();
		out.close();
	}

}
