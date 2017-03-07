package com.servlets.contextinitparams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  ServletParameters class. 0303 Context/Servlet Init Parameters.
 *  A Servlet can be added in the web.xml with name as well as an init
 *  param. Param name is case sensitive.
 *
 *  A context param in web.xml is more of a global parameter for the entire
 *  application context. It will be available to any of our servlets or pages
 *  in the entire application for this context.
 *
 *  Notice there is no name or urlPattern specified for @WebServlet because
 *  they are read from web.xml as <servlet-name> and <service-class>
 */
@WebServlet()
public class ServletParameters extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletParameters() {
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

        // in this servlet, we have access to the local servlet init-parameter
        // and the global context-parameter set in the web.xml file.
        String secretCode =
                getServletConfig().getInitParameter("secretCode");

        String dbURL =
                getServletContext().getInitParameter("dbURL");

        //spit out the information
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String outString = String.format("Secret Code: %s\tDB URL: %s\n",
                secretCode, dbURL);

        out.println("<html><body><h3>" + outString + "</h3></body></html>");
    }
}
