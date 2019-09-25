package com.metacube.MetacubeParkingJdbc.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * It is class for filter implementation
 * @author Khushi
 *
 */
public class ValidationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("email") != null){
			chain.doFilter(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login?msg=Session Expired!");
        	rd.include(request, response);
		}		
	}
}