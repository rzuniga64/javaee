package com.servlets.sessionlisteners;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowActiveSessionCount.
 */
@WebServlet(name = "ShowActiveSessionCount",
            urlPatterns = {"/showactivesessioncount.do"})
public class ShowActiveSessionCount extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     *  @see HttpServlet#HttpServlet()
     */
    public ShowActiveSessionCount() {
        super();
    }

    /**
     /**
     * doGet method.
     * @param request request
     * @param response response
     * @throws ServletException Servlet Exception
     * @throws IOException IOException
     * @see HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {

        //all we'll do here is just print out the active user count
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        int activeUsers = ActiveUserTracking.getActiveUserCount();
        out.println("<h1>Active Users: " + activeUsers + "</h1>");
        out.println("</body></html>");
    }
}
