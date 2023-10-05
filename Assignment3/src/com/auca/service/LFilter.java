package com.auca.service;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/login")
public class LFilter implements Filter {
    public LFilter() {
    }
	public void destroy() {
		
	}	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("name") == null) {
			res.sendRedirect(req.getContextPath() + "/Admission.html");
		}else {
		chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
