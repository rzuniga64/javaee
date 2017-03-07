package com.servlets.contextinitparams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletParameters2.
 *  ServletParameters class. 0303 Context/Servlet Init Parameters.
 *  A Servlet can be added in the web.xml with name as well as an init
 *  param. Param name is case sensitive.
 *
 *  A context param in web.xml is more of a global parameter for the entire
 *  application context. It will be available to any of our servlets or pages
 *  in the entire application for this context.
 *
 *  The WebServlet URL does not give you access to init-param in the
 *  deployment descriptor. You have to use the url-pattern specified in the
 *  file. So if you try to access init-param it won't work.
 */
@WebServlet(name = "ServletParameters", urlPatterns = {"/ServletParameters"})
public class ServletParameters2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletParameters2() {
        super();
    }

    /**
     * doGet method.
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     * @see HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {
        String secretCode =
                getServletConfig().getInitParameter("secretCode");

        String dbURL =
                getServletContext().getInitParameter("dbURL");

        //spit out the information
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String outString = String.format("Secret Code: %s\tDB URL: %s\n",
                (secretCode == null ? "unauthorized" : secretCode), dbURL);

        out.println("<html><body><h3>" + outString + "</h3></body></html>");
    }
}
