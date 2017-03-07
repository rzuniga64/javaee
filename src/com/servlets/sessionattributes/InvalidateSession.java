package com.servlets.sessionattributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InvalidateSession.
 * Invalidates the session.  Run this file in the browser and then go to
 * destinationpage.do. You will see 'unauthorized' in the browser.
 */
@WebServlet(name = "InvalidateSession",
            urlPatterns = {"/invalidatesession.do"})
public class InvalidateSession extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidateSession() {
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

        HttpSession session = request.getSession();
        session.invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Session invalidated, please login again");
    }
}
