package com.shopping.zhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Category;
import com.shopping.zhang.service.impl.CategoryServiceImpl;

public class GetTreeMenueDataServlet extends HttpServlet {
	private static final long serialVersionUID = -8058684381519761020L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires",0); 
		response.setHeader("Pragma","no-cache"); 
		
		List<Category> categories = CategoryServiceImpl.getInstance().showCategory();
		Iterator<Category> i = categories.iterator();
		StringBuffer str = new StringBuffer("[");
		while(i.hasNext()){
			Category category = i.next();
			str.append("{id:").append(category.getId()).append(",").append("name:").append("\"").append(category.getName()).append("\"").append(",").append("pid:").append(category.getPid()).append("},");
			
		}
		str.deleteCharAt(str.length()-1);
		str.append("]");
		PrintWriter out = response.getWriter();
		System.out.println(str);
		out.print(str);
		out.flush();
		out.close();
	}

}
