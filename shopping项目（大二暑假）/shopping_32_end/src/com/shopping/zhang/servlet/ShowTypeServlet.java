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
		//获得大类的id
		int pid = Integer.parseInt(request.getParameter("pid"));
		//获得小类的id
		int cid = Integer.parseInt(request.getParameter("cid"));
		//获得大类的类字
	    String pname = CategoryServiceImpl.getInstance().showCategoryById(pid).getName();
	    //获得小类的类名
	    String cname = CategoryServiceImpl.getInstance().showCategoryById(cid).getName();
	    request.setAttribute("pname", pname);
	    request.setAttribute("cname", cname);
	    //查询出所有的类别，用来显示页面左侧的树形菜单
	    List<Category> categories = CategoryServiceImpl.getInstance().showCategory();
	    request.setAttribute("categories", categories);
	    //查询出属于该小类的所有商品
	    List<Goods> goods = GoodsServiceImpl.getInstance().showGoodsByCategoryId(cid,"");
	    request.setAttribute("goods", goods);
	    request.getRequestDispatcher("type.jsp").forward(request, response);
	}

}
