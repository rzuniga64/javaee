package com.servlets.intro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  DO NOT USE! Use RequestDispatcher instead.
 *  Redirect is part of HTTP response object and used to move from link to link.
 *  For Glassfish server I had to prepend the URL with the artifact in the run
 *  Intellij run configuration. Remember the URL is configured in the deployment
 *  descriptor(web.xml). See HelloWorld.java.
 */
@WebServlet(name = "Redirect",
            urlPatterns = {"/redirect.do"})
public class Redirect extends HttpServlet {

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

        response.sendRedirect("/javaee_war_exploded/helloworld.do");
    }
}
