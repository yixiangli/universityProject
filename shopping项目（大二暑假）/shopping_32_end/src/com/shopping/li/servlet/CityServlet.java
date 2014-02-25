/**
* @package_name   com.shopping.li.servlet
* @file_name CityServlet.java
* @author Administrator
* @date 2013-7-28
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @ClassName: CityServlet
 * @Description: TODO
 */
public class CityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String area1 = request.getParameter("area1");
		String area2 = request.getParameter("area2");
		String area3 = request.getParameter("area3");
		
		String location = area1+""+area2+""+area3;
		
		out.flush();
		out.close();
	}

}
