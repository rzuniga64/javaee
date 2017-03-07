package com.servlets.sessionattributes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authorized.
 * Need a login credential to use this page. We will get the session from the
 * request object. Then we check user's credential attributes from the session.
 * If authorized it will go to destinationpage.do otherwise it send the user to
 * the login page.
 */
@WebServlet(name = "Authorized", urlPatterns = {"/authorizedpage.do"})
public class Authorized extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authorized() {
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
        boolean authorized = false;
        String uid = null;
        int authLevel = -1;

        if (session.getAttribute("userName") != null) {
            uid = (String) session.getAttribute("userName");
        }
        if (session.getAttribute("userAuthLevel") != null) {
            authLevel = (int) session.getAttribute("userAuthLevel");
        }

        if (authLevel >= 1 && uid != null && !uid.equals("")) {
            authorized = true;
        }

        if (!authorized) {
            response.sendRedirect("login.html");
        } else {
            response.sendRedirect("destinationpage.do");
        }
    }
}
