/*
 *Author Name : Manikandan
 *Date : 24-01-2023
 */
package com.stackroute.Automotive.Vehicles.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authHeader  = request.getHeader("authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer")){
            throw new ServletException("Token is missing");
        }
        else {
            String token = authHeader.substring(7);
            System.out.println("\nIn Filter class, Token : "+ token);
            Claims claims = Jwts.parser().setSigningKey("privacy").parseClaimsJws(token).getBody();
            // if above parsing success, claims variable gets user  details
            System.out.println("\nIn Filter, claims  :" + claims);
            request.setAttribute("curr_user_emailId",claims.get("emailId"));
            filterChain.doFilter(request,response);
        }
    }
    }

