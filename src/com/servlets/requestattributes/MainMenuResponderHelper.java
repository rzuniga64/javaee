package com.servlets.requestattributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenuResponderHelper.
 */
@WebServlet(name = "MainMenuResponderHelper",
            urlPatterns = {"/requestattributeshelper.do"})
public class MainMenuResponderHelper extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        // attributes come in as object that have to be Strings.
        String useDB = (String) request.getAttribute("useDB");
        String sendEmail = (String) request.getAttribute("sendEmail");
        String choice = (String) request.getAttribute("userChoice");

        // here we'll just spit out what we know and should do so we can see
        // the attributes working as expected
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pageToNavigate = "";
        if (choice.equals("1")) {
            pageToNavigate = "List all Cities";
        } else if (choice.equals("2")) {
            pageToNavigate = "Add a City";
        } else if (choice.equals("3")) {
            pageToNavigate = "Delete a City";
        }

        boolean optEmail = (sendEmail == null ? false : sendEmail.equals("1"));
        boolean optDB = (useDB == null ? false : useDB.equals("1"));

        String message = String.format("<span>You chose to show the "
                + "page to %s and set useDB to %b and sendEmail to "
                + "%b</span>", pageToNavigate, optDB, optEmail);
        out.println("<html><body><h1>" + message + "</h1></body></html>");
    }
}
