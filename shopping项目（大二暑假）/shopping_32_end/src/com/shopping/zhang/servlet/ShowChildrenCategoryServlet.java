package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Category;
import com.shopping.zhang.service.impl.CategoryServiceImpl;

public class ShowChildrenCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = -2486622633426093427L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//���id��������е�����
		int id = Integer.parseInt(request.getParameter("id"));
		List<Category> categories = CategoryServiceImpl.getInstance().showChilerenCategory(id);
	    //Ϊ��������ṩ�����id
		request.setAttribute("pid", id);
		request.setAttribute("categories", categories);
	    String categoryName = CategoryServiceImpl.getInstance().showCategoryById(id).getName();
	    request.setAttribute("categoryName", categoryName);
	    request.getRequestDispatcher("subType.jsp").forward(request, response);
	    
	}

}
