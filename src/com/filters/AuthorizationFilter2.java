package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabeans.models.WebUser;

/**
 *  AuthorizationFilter2 class.
 */
public class AuthorizationFilter2 implements Filter {

    /**
     *  Default constructor.
     */
    public AuthorizationFilter2() { }

    /**
     *  @see Filter#destroy()
     */
    public void destroy() { }

    /**
     *  doFilter method.
     *  @param request request
     *  @param response response
     *  @param chain chain
     *  @throws IOException IOException
     *  @throws ServletException ServletException
     *  @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain)
                         throws IOException, ServletException {

        //verify user is logged in
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //validate using session
        HttpSession s = req.getSession();
        WebUser wu = (WebUser) s.getAttribute("authorized_user");

        if (wu == null) {
            String target =
            "http://localhost:8082/javaee_war_exploded/index.jsp";
            res.sendRedirect(target);
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    /**
     *  init method.
     *  @param fConfig fConfig
     *  @throws ServletException ServletException
     *  @see Filter#init(FilterConfig)
     */
    public void init(final FilterConfig fConfig) throws ServletException { }
}
