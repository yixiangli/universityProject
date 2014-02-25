package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Publish;
import com.shopping.zhang.service.impl.PublishServiceImpl;

public class PublishModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 2047604509528875245L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Publish publish = PublishServiceImpl.getInstance().showPublishById(id);
	    request.setAttribute("publish", publish);
	    request.getRequestDispatcher("placard_modify.jsp").forward(request, response);
	}

}
