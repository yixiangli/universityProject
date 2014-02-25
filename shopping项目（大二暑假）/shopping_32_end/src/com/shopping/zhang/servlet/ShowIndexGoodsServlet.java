package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Category;
import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.CategoryServiceImpl;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowIndexGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 689741000011862978L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Goods> newGoods = GoodsServiceImpl.getInstance().getBeforeGoods(GoodsServiceImpl.NEW_GOODS);
	    request.setAttribute("newGoods", newGoods);
	    List<Goods> bargainGoods = GoodsServiceImpl.getInstance().getBeforeGoods(GoodsServiceImpl.BARGAIN_GOODS);
	    request.setAttribute("bargainGoods", bargainGoods);
	    List<Category> categories = CategoryServiceImpl.getInstance().showCategory();
	    request.setAttribute("categories", categories);
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
