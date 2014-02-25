package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.impl.CategoryServiceImpl;


public class AddCategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3044804060251728180L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String categoryName = request.getParameter("typename");
		int pid = Integer.parseInt(request.getParameter("pid"));
		String info = request.getParameter("info");
		//��ӵ���С��,ҳ����ת��С����ҳ��
		if(pid > 1){
			CategoryServiceImpl.getInstance().saveCategory(categoryName, pid, info);
			request.getRequestDispatcher("showChildrenCategory.do?id="+pid).forward(request, response);
		}else if(pid == 1){
			//��ӵ��Ǵ���,ҳ����ת�������ҳ��
		    CategoryServiceImpl.getInstance().saveCategory(categoryName, 1, info);
		    request.getRequestDispatcher("ParameterManage.jsp").forward(request, response);
		}
	}

}
