package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Category;
import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.CategoryServiceImpl;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowManageGoodsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 3057420630989418516L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		
		//���type��1������ת����Ʒ��ϸҳ��
		//���typeΪ2������ת����Ʒ�޸�ҳ��
		int type = Integer.parseInt(request.getParameter("type"));
		Goods good = GoodsServiceImpl.getInstance().showGoodsById(gid);
		request.setAttribute("good", good);
		String url = null;
		if(type == 1){
			//���С�������
			String cname = good.getSort().getName();
			request.setAttribute("cname", cname);
			url = "goods_detail.jsp";
		}else if(type == 2){
			//��ô��������
			Category category = CategoryServiceImpl.getInstance().showCategoryById(good.getSort().getPid());
			String pname = category.getName();
			int pid = category.getId();
			request.setAttribute("pname", pname);
			request.setAttribute("pid", pid);
			//���С�������
			String cname = good.getSort().getName();
			//�õ�С���id
			int sortId = good.getSort().getId();
			request.setAttribute("sortId", sortId);
			request.setAttribute("cname", cname);
			url = "goods_modify.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
