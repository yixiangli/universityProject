package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.vo.GoodsManageVo;
import com.shopping.po.Publish;
import com.shopping.zhang.service.impl.PublishServiceImpl;

public class ShowPublishServlet extends HttpServlet {
	private static final long serialVersionUID = -7089153737750855089L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		List<Publish> publishs1 = PublishServiceImpl.getInstance().showPublish();
		List<Publish> publishs = PublishServiceImpl.getInstance().showPublish(nowpage);
	    
		GoodsManageVo publishVo = new GoodsManageVo();
		publishVo.setPagesize(6);
		publishVo.setNumcount(publishs1.size());
		publishVo.setNowpage(nowpage);
		publishVo.setLastpage();
		publishVo.setNextpage();
		publishVo.setPagecount();
		publishVo.setPreviouspage();
	    
	    request.setAttribute("publishVo", publishVo);
		request.setAttribute("publishs", publishs);
	    request.getRequestDispatcher("PlacardManage.jsp").forward(request, response);
 	}

}
