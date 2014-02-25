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
		//�õ��丸���id,��������id>1���ʾ��������������ɾ��������
		//��Ӧ����ת�������б�
		int pid = CategoryServiceImpl.getInstance().showCategoryById(id).getPid();
	    CategoryServiceImpl.getInstance().deleteCategory(id);
	    if(pid>1){
	    	request.getRequestDispatcher("showChildrenCategory.do?id="+pid).forward(request, response);
	    }else if(pid == 1){
	    	request.getRequestDispatcher("ParameterManage.jsp").forward(request, response);
	    }
	    
	}

}
