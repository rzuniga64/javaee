package com.jsp.systemwideerrorhandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimulateException. We can't run scripting so
 * we are going to simulate and exception.
 */
@WebServlet(name = "SimulateException",
            urlPatterns = {"/simulateException.do"})
public class SimulateException extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimulateException() {
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
        int i = 10;
        int j = 0;
        int k = i / j;
        PrintWriter out = response.getWriter();
        out.println("The result is " + k);
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
