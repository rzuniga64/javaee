package com.filters;

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

import com.wrappers.ParameterInspector;

/**
 * Servlet Filter implementation class ParamterInspector.
 */
// /* will cause all urls to be filtered and parameter intercept
@WebFilter("/*")
public class ParameterFilter implements Filter {

    /** Default constructor. */
    public ParameterFilter() { }

    /**
     *  destroy method.
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

        //wrap the request with the inspector
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // pass the request along the filter chain
        chain.doFilter(new ParameterInspector(req), res);
    }

    /**
     *  init method.
     *  @param fConfig fConfig
     *  @throws ServletException ServletException
     *  @see Filter#init(FilterConfig)
     */
    public void init(final FilterConfig fConfig) throws ServletException { }

}
