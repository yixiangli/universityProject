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
import com.shopping.zhang.service.impl.SearchGoodsServiceImpl;

public class ShowSearchServlet extends HttpServlet {
	private static final long serialVersionUID = -7325476175925189750L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��ѡ�����id
		int categoryId = Integer.parseInt(request.getParameter("type"));
		//�������Ĺؼ���
		String gname = request.getParameter("key");
		
		List<Goods> searchGoods = null;
		if(categoryId == 1){
			request.setAttribute("Name", "全部分类");
		}else{
			//��ô��������
		    Category category = CategoryServiceImpl.getInstance().showCategoryById(categoryId);
		    request.setAttribute("Name", category.getName());
		}
		request.setAttribute("keyWord", gname);
		//��������Ľ��
		searchGoods = SearchGoodsServiceImpl.getInstance().showSearchGoods(categoryId, gname);
		
		request.setAttribute("searchGoods", searchGoods);
		request.getRequestDispatcher("search_deal.jsp").forward(request, response);
	}

}
