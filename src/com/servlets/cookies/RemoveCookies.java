package com.servlets.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Servlet implementation class RemoveCookies.
 *  Loop on the cookie array, find the cookie we want to remove, set the max
 *  age to zero to expire it, add that cookie back into the response so that
 *  the cookie is overwritten.
 */
@WebServlet(name = "RemoveCookies",
            urlPatterns = {"/removecookies.do"})
public class RemoveCookies extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCookies() {
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

        //just remove the cookies for our variables (could
        // easily remove all, etc.
        // response.setContentType("text/html");
        Cookie[] mycookies = request.getCookies();
        if (mycookies != null && mycookies.length > 0) {
            for (Cookie c : mycookies) {
                if (c.getName().toLowerCase().contains("credentials")) {
                    //expire the cookie
                    c.setMaxAge(0);
                    // add cookie back into response so cookie is overwritten.
                    response.addCookie(c);
                }
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body><h3>Cookies expired."
                + "</h3></body></html>");
    }
}
