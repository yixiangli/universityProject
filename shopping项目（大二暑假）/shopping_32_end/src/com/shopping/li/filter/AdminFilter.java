/**
* @package_name   com.shopping.li.filter
* @file_name AdminFilter.java
* @author Administrator
* @date 2013-8-1
*/
package com.shopping.li.filter;

 

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Admin;

/** 
 * @ClassName: AdminFilter
 * @Description: TODO
 */
public class AdminFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
 
 
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request =   (HttpServletRequest) req;	 
		HttpServletResponse response = (HttpServletResponse) resp;
		
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		if(admin!=null || request.getServletPath().equals("/manage/adminLogin.do")){
			//放行		
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
