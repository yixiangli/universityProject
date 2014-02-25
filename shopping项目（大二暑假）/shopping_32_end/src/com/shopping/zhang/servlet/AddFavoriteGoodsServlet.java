package com.shopping.zhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.po.User;
import com.shopping.zhang.service.FavoriteService;
import com.shopping.zhang.service.impl.FavoriteServiceImpl;

public class AddFavoriteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 3922326061666196213L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gidString = request.getParameter("gid");
			
		if( gidString != null){
			
			int gid = Integer.parseInt(gidString);
			FavoriteService favorite = FavoriteServiceImpl.getInstance();
			PrintWriter out = response.getWriter();
			User user = (User)request.getSession().getAttribute("user");
			int uid = 0;
			if(user == null){
				out.print("您还没有登陆，请登陆！！！");
				
			}else{
				uid = user.getId();
				int type = 0;
				List<Goods> goods = FavoriteServiceImpl.getInstance().showFavoriteGoods(uid);
			    for(Iterator<Goods> i=goods.iterator();i.hasNext();){
			    	Goods good = i.next();
			    	if(good.getId() == gid){
			    		type = 1;
			    		break;
			    	}
			    }
			    if(type == 1){
			    	out.print("你已收藏了该商品");
			    	
			    }else if(type == 0){
			        favorite.saveFavorite(uid, gid);
			        out.print("收藏成功");
			        
			    }
			}
			out.flush();
			out.close();
		}else{
			
		}
		
	}
}
