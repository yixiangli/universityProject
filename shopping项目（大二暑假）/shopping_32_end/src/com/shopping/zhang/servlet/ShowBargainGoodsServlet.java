package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowBargainGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = -2979816962175500560L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Goods> bargainGoods = GoodsServiceImpl.getInstance().showGoodsByBargainPrice();
	    request.setAttribute("bargainGoods", bargainGoods);
	    request.getRequestDispatcher("sale.jsp").forward(request, response);
	}

}
