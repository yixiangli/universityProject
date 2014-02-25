package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.zhang.service.impl.PublishServiceImpl;

public class DeletePublishServlet extends HttpServlet {
	private static final long serialVersionUID = -8263507399121356402L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PublishServiceImpl.getInstance().deletePublishById(id);
		request.getRequestDispatcher("PlacardManage.jsp").forward(request, response);
	}

}
