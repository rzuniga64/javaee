package com.servlets.sessionattributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestinationPage.
 */
@WebServlet(name = "DestinationPage", urlPatterns = {"/destinationpage.do"})
public class DestinationPage extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinationPage() {
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession s = request.getSession();
        if (s != null && !s.isNew() && s.getAttribute("userName") != null) {
            String uid = (String) s.getAttribute("userName");
            out.println("<html><body><span>Welcome<span>&nbsp;<strong>"
                    + uid + "</strong></body></html>");
        } else {
            out.println("<html><body><span>Unauthorized<span></body></html>");
        }
    }
}
