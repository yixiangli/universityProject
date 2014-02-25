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

public class ShowManageSearchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 60609079399880309L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires",0); 
		response.setHeader("Pragma","no-cache"); 
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<Category> categories = null;
		if(pid == 1){
			//��ѯ�����еĴ���,����1��ѯ���б�ŵ��࣬2����ѯ��û�б�ŵ���
		    categories = CategoryServiceImpl.getInstance().showBigCategory();
		}else if(pid >1){
			//��ѯ���е�С��
			categories = CategoryServiceImpl.getInstance().showChilerenCategory(pid);
		}
		
		StringBuffer str = new StringBuffer("[");
		Iterator<Category> i = categories.iterator();
		while(i.hasNext()){
			Category category = i.next();
			str.append("{id:").append(category.getId()).append(",").append("name:").append("\"").append(category.getName()).append("\"").append("},");
		}
		str.deleteCharAt(str.length()-1);
		str.append("]");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
}
