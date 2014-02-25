package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Category;
import com.shopping.zhang.service.impl.CategoryServiceImpl;

public class ShowParentCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = -7831284090655270896L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
        List<Category> categories =  CategoryServiceImpl.getInstance().showBigCategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("ParameterManage.jsp").forward(request, response);
	}

}
