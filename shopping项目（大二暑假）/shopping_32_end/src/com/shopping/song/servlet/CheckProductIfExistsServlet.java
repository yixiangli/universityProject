package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.GoodsService;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class CheckProductIfExistsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsService goodsService = GoodsServiceImpl.getInstance();

		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		PrintWriter out = response.getWriter();
		
		int number = goodsService.showGoodsById(goodsId).getNumber();
		if(number>0){
		  StringBuffer jsonString = new StringBuffer("[");
		  jsonString.append("{\"number\":").append(number).append("}]");
		  System.out.println(jsonString);
		  out.print(jsonString);
		}else{
			out.print("[]");
		}
		out.flush();
		out.close();
	}
	}


