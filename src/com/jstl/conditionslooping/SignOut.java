package com.jstl.conditionslooping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignOut.
 */
@WebServlet(name = "SignOut", urlPatterns = {"/signout.do"})
public class SignOut extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet()
     */
    public SignOut() {
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
        response.sendRedirect("index.jsp");
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
    protected void doPost(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
