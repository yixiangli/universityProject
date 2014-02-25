package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.vo.GoodsManageVo;
import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.CategoryServiceImpl;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowManageSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1632907087571740566L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));

		int type = Integer.parseInt(request.getParameter("type"));
		String keyword = request.getParameter("key");
		List<Goods> goods = null;
		List<Goods> goods1 = null;
		List<Goods> GOODS = null;
		GoodsManageVo goodsManageVo = new GoodsManageVo();
		String typeName = "ȫ�����";
		if (keyword == "") {
			goods1 = GoodsServiceImpl.getInstance().showGoods();
			goods = GoodsServiceImpl.getInstance().showGoods(nowpage);
			GOODS = goods1;
		} else {
			// typeΪ1�����е���Ʒ��ƥ����Ӧ�Ĺؼ��֣���������Ӧ�������ƥ����Ӧ�Ĺؼ���
			if (type == 1) {
				goods = GoodsServiceImpl.getInstance().showGoodsByCategoryId(
						type, keyword);
			} else {
				int subtype = Integer.parseInt(request.getParameter("subtype"));
				goods = GoodsServiceImpl.getInstance().showGoodsByCategoryId(
						subtype, keyword);
				typeName = CategoryServiceImpl.getInstance()
						.showCategoryById(subtype).getName();
			}
			GOODS = goods;
		}

		goodsManageVo.setPagesize(6);
		goodsManageVo.setNumcount(GOODS.size());
		goodsManageVo.setNowpage(nowpage);
		goodsManageVo.setLastpage();
		goodsManageVo.setNextpage();
		goodsManageVo.setPagecount();
		goodsManageVo.setPreviouspage();
		request.setAttribute("goodsManageVo", goodsManageVo);
		request.setAttribute("typeName", typeName);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("GoodsManage.jsp").forward(request,
				response);
	}

}
