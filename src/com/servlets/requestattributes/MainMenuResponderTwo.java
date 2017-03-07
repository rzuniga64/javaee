package com.servlets.requestattributes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenuResponderTwo.
 * Set request attributes to pass on to the next object (servlet or page).
 * We longer are passing query strings in the URL.
 */
@WebServlet(name = "MainMenuResponderTwo",
            urlPatterns = {"/requestattributes.do"})
public class MainMenuResponderTwo extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainMenuResponderTwo() {
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

        // get the form parameter that was posted -- the parameter name is the
        // name of the option select
        String userChoice = request.getParameter("menuChoice");
        String[] userOptions = request.getParameterValues("adminoptions");

        // instead of building a query string, just set attributes to pass on to
        // the next object (servlet or page)
        request.setAttribute("userChoice", userChoice);

        // now we can pass the information without having to show it in the
        // query string...
        if (userOptions != null) {
            for (String userOption : userOptions) {
                if (userOption.equalsIgnoreCase("useDB")) {
                    request.setAttribute("useDB", "1");
                }

                if (userOption.equalsIgnoreCase("sendEmail")) {
                    request.setAttribute("sendEmail", "1");
                }
            }
        }

        // one other nice feature about attributes vs. parameters is that we can
        // send any object in the attribute, not just a single string with a
        // matching value as String.

        // however, HTML files can't read attributes, so let's first send to an
        // intermediary servlet (in the future, we'll learn how we can access
        // java code like the attributes from a jsp page)
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/requestattributeshelper.do");
        dispatcher.forward(request, response);
    }
}
