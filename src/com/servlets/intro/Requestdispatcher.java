package com.servlets.intro;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  javax.servlet.RequestDispatcher allows us to redirect without showing the
 *  Servlet that will be run in the URL. The code that is run behind the scene is
 *  HelloWorld. This is done with the response method
 *  getRequestDispatcher(String link). We then forward that dispatcher.
 *  Notice we no longer need th artifact in the URL!
 *
 *  Remember the URL is configured in the deployment descriptor(web.xml).
 *  See HelloWorld.java.
 */
@WebServlet(name = "Requestdispatcher",
            urlPatterns = {"/requestdispatcher.do"})
public class Requestdispatcher extends HttpServlet {

    /**
     *
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {

        RequestDispatcher dispatcher = request.
                getRequestDispatcher("/helloworld.do");
        dispatcher.forward(request, response);
    }
}
