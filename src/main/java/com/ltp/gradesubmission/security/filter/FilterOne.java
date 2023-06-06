package com.ltp.gradesubmission.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class FilterOne implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(((HttpServletRequest) request).getRequestURI());
        System.out.println("Filter One Invoked !");
        chain.doFilter(request, response);
    }
}
