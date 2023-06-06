package com.ltp.gradesubmission.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class FilterTwo implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        System.out.println(((HttpServletRequest) request).getRequestURI());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println("Filter Two Invoked !");
        chain.doFilter(request, response);
    }
}
