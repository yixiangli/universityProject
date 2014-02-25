package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class DeleteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 7690497832005332064L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("id"));
		GoodsServiceImpl.getInstance().deleteGoodsById(gid);
		request.getRequestDispatcher("GoodsManage.jsp").forward(request, response);
	}

}
