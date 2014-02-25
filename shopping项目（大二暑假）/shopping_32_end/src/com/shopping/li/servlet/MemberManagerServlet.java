/**
* @package_name   com.shopping.li.servlet
* @file_name MemberManagerServlet.java
* @author Administrator
* @date 2013-7-25
*/
package com.shopping.li.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.li.service.impl.AdminServiceImpl;
import com.shopping.li.vo.UserVo;
import com.shopping.po.User;


/** 
 * @ClassName: MemberManagerServlet
 * @Description: TODO
 */
public class MemberManagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		List<User> users = AdminServiceImpl.getInstance().showUsers(nowpage);
		List<User> user = AdminServiceImpl.getInstance().showUsers();
		UserVo userVo = new UserVo();
		userVo.setNowpage(nowpage);
		userVo.setPagesize(3);
		userVo.setNumcount(user.size());
		userVo.setLastpage();
		userVo.setNextpage();
		userVo.setPagecount();
		userVo.setPreviouspage();
		request.setAttribute("userVo", userVo);
		request.setAttribute("User", users);
		request.getRequestDispatcher("MemberManage.jsp").forward(request, response);
	}

}
