package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowNewGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 6347632988548705306L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Goods> newGoods = GoodsServiceImpl.getInstance().showNewGoods();
	    request.setAttribute("newGoods", newGoods);
	    request.getRequestDispatcher("NewGoods.jsp").forward(request, response);
	}

}
