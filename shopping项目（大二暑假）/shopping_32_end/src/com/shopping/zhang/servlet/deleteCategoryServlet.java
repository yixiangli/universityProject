package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.impl.CategoryServiceImpl;

public class deleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = -2815297533466329647L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//得到其父类的id,如果父类的id>1则表示是在子类的类表中删除的数据
		//则应当跳转到子类列表
		int pid = CategoryServiceImpl.getInstance().showCategoryById(id).getPid();
	    CategoryServiceImpl.getInstance().deleteCategory(id);
	    if(pid>1){
	    	request.getRequestDispatcher("showChildrenCategory.do?id="+pid).forward(request, response);
	    }else if(pid == 1){
	    	request.getRequestDispatcher("ParameterManage.jsp").forward(request, response);
	    }
	    
	}

}
