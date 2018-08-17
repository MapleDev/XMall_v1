package com.xznn.web.filter;


import com.xznn.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PriviledgeFilter implements Filter {

    public PriviledgeFilter() {
    }


	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest myReq=(HttpServletRequest)request;
		//判断当前的session中是否存在已经登录成功的用户
		User user=(User)myReq.getSession().getAttribute("loginUser");
		if(null!=user){
			//如果存在,放行
			chain.doFilter(request, response);
		}else{
			//如果不存在,转入到提示页面
			myReq.setAttribute("msg", "请用户登录之后再去访问");
			//转入到提示页面
			myReq.getRequestDispatcher("/jsp/info.jsp").forward(request, response);
		}
		
		
	
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
