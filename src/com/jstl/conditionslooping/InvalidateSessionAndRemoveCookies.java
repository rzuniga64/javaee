package com.jstl.conditionslooping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InvalidateSessionAndRemoveCookies.
 */
@WebServlet(name = "InvalideSessionAndRemoveCookies",
        urlPatterns = {"/invalidatesessionandremovecookies.do"})
public class InvalidateSessionAndRemoveCookies extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet()
     */
    public InvalidateSessionAndRemoveCookies() {
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

        HttpSession s = request.getSession();
        s.invalidate();

        Cookie[] mycookies = request.getCookies();
        if (mycookies != null && mycookies.length > 0) {
            for (Cookie c : mycookies) {
                if (c.getName().toLowerCase().contains("credentials")) {
                    //expire the cookie
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

        response.sendRedirect("ClearSessionsAndCookies.jsp");
    }

    /**
     * doPost method.
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     * @see HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
                          throws ServletException, IOException {
        doGet(request, response);
    }
}
