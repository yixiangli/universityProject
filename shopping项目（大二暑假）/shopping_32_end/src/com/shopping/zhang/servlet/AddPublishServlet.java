package com.shopping.zhang.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Publish;
import com.shopping.zhang.service.impl.PublishServiceImpl;

public class AddPublishServlet extends HttpServlet {
	private static final long serialVersionUID = -5438990765111667624L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//当id=0时表示插入公告，当id>0时表示修改公告
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//将生效时间和过期时间转换成Timestamp格式
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		Timestamp publishTime = null;
		Date outTime = null;
		try {
			publishTime = new Timestamp(format.parse(request.getParameter("publishTime")).getTime());
			outTime = new Timestamp(format.parse(request.getParameter("outTime")).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        Publish publish = new Publish();
        publish.setTitle(title);
        publish.setContent(content);
        publish.setPublishTime(publishTime);
        publish.setOutTime(outTime);
        if(id == 0){
        	PublishServiceImpl.getInstance().savePublish(publish);
        }else if(id>0){
        	PublishServiceImpl.getInstance().updatePublishById(publish, id);
        }
        
        request.getRequestDispatcher("PlacardManage.jsp").forward(request, response);
	}

}
