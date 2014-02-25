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

public class ShowTypeServlet extends HttpServlet {
	private static final long serialVersionUID = -5683208201538001271L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ô����id
		int pid = Integer.parseInt(request.getParameter("pid"));
		//���С���id
		int cid = Integer.parseInt(request.getParameter("cid"));
		//��ô��������
	    String pname = CategoryServiceImpl.getInstance().showCategoryById(pid).getName();
	    //���С�������
	    String cname = CategoryServiceImpl.getInstance().showCategoryById(cid).getName();
	    request.setAttribute("pname", pname);
	    request.setAttribute("cname", cname);
	    //��ѯ�����е����������ʾҳ���������β˵�
	    List<Category> categories = CategoryServiceImpl.getInstance().showCategory();
	    request.setAttribute("categories", categories);
	    //��ѯ�����ڸ�С���������Ʒ
	    List<Goods> goods = GoodsServiceImpl.getInstance().showGoodsByCategoryId(cid,"");
	    request.setAttribute("goods", goods);
	    request.getRequestDispatcher("type.jsp").forward(request, response);
	}

}
