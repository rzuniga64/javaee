package com.expressionlanguage.implicitobjects;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Servlet implementation class RequestScope.
 *  Used when we want to pass some objects to the request scope.
 */
@WebServlet(name = "/RequestScope.do", urlPatterns = {"/requestscope.do"})
public class RequestScope extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestScope() {
        super();
    }

    /**
     * doGet method.
     * @param request request
     * @param response response
     * @throws ServletException Servlet Exception
     * @throws IOException IOException
     * @see HttpServlet#doPost(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {

        request.setAttribute("uid", "reqUser");
        request.setAttribute("pwd", "reqUserPwd");
        RequestDispatcher rd = request.getRequestDispatcher("RequestScope.jsp");
        rd.forward(request, response);
    }
}
