package com.shopping.zhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Publish;
import com.shopping.zhang.service.impl.PublishServiceImpl;

public class ShowIndexPublishInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1064102331587995847L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires",0); 
		response.setHeader("Pragma","no-cache"); 
		
		List<Publish> publishs = PublishServiceImpl.getInstance().showPublish();
		
		StringBuffer str = new StringBuffer("[");
		Iterator<Publish> publish = publishs.iterator();
		while(publish.hasNext()){
			Publish pub = publish.next();
			str.append("{id:").append(pub.getId()).append(",").append("title:").append("\"").append(pub.getTitle()).append("\"").append("},");
		}
		str.deleteCharAt(str.length()-1);
		str.append("]");
		PrintWriter out = response.getWriter();
  		out.print(str);
	    out.flush();
	    out.close();
	}

}
