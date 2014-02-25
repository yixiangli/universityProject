package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.FavoriteServiceImpl;

public class ShowFavoriteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = -8216943133313625901L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		List<Goods> goods = FavoriteServiceImpl.getInstance().showFavoriteGoods(uid);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("favorite.jsp").forward(request, response);
	}
}
