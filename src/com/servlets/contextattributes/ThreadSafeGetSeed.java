package com.servlets.contextattributes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Servlet implementation class ThreadSafeGetSeed.
 *
 *  getServletContext() is an application wide attribute that we use across
 *  multiple requests. So when many requests are using the website we need some
 *  thread safety. ServletContext is at the application level.
 *
 *  Request attribute lives on the request object so when the request is gone
 *  the attribute is gone.
 */
@WebServlet(name = "ThreadSafeGetSeed", urlPatterns = {"/threadsafegetseed.do"})
public class ThreadSafeGetSeed extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSafeGetSeed() {
        super();
    }

    /**
     * doPost method.
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     * @see HttpServlet#doPost(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
                          throws ServletException, IOException {

        // retrieve the form parameter user selection
        String doThreadSafe = request.getParameter("threadsafetyselection");

        //retrieve the context parameter for initial seed
        int initialSeed = Integer.parseInt(getServletContext().
                getInitParameter("initialseed"));

        //seed the servlet context attribute for current seed from web.xml
        getServletContext().setAttribute("currentSeedValue", initialSeed);

        //determine where to direct traffic
        if (doThreadSafe.equalsIgnoreCase("requestthread")) {
            response.sendRedirect("nonthreadsaferequest.do");
        } else if (doThreadSafe.equalsIgnoreCase("nonthreadsafe")) {
            response.sendRedirect("nonthreadsafeservlet.do");
        } else if (doThreadSafe.equalsIgnoreCase("threadsafe")) {
            response.sendRedirect("threadsafeservlet.do");
        } else {
            response.sendRedirect("index.html");
        }
    }
}
