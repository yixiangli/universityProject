package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.vo.GoodsManageVo;
import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowGoods_ManageServlet extends HttpServlet {
	private static final long serialVersionUID = -2777431820961295873L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		List<Goods> goods1 = GoodsServiceImpl.getInstance().showGoods();
		List<Goods> goods = GoodsServiceImpl.getInstance().showGoods(nowpage);
		
		GoodsManageVo goodsManageVo = new GoodsManageVo();
	    goodsManageVo.setPagesize(4);
	    goodsManageVo.setNumcount(goods1.size());
	    goodsManageVo.setNowpage(nowpage);
	    goodsManageVo.setLastpage();
	    goodsManageVo.setNextpage();
	    goodsManageVo.setPagecount();
	    goodsManageVo.setPreviouspage();
	    
	    request.setAttribute("goodsManageVo", goodsManageVo);
		request.setAttribute("goods", goods);
	    request.getRequestDispatcher("GoodsManage.jsp").forward(request, response);
	}

}
