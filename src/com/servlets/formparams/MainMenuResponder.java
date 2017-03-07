package com.servlets.formparams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenuResponder.
 */
@WebServlet(name = "FormParamters",
            urlPatterns = {"/formparameters.do"})
public class MainMenuResponder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainMenuResponder() {
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get the form parameter that was posted -- the parameter name is the
        // name of the option select
        String userChoice = request.getParameter("menuChoice");
        String[] userOptions = request.getParameterValues("adminoptions");

        // build a parameter string based on what was passed to the servlet to
        // propagate on to the system so we can see the form values going in
        // the query string and continuing on in the system so we can use them.
        StringBuilder params = new StringBuilder("");
        String queryStringParams = "";

        if (userOptions != null) {
            boolean isFirst = true;
            for (String userOption : userOptions) {
                if (!isFirst) {
                    params.append("&");
                } else {
                    params.append("?");
                }

                if (userOption.equalsIgnoreCase("useDB")) {
                    params.append("useDB=1");
                } else if (userOption.equalsIgnoreCase("sendEmail")) {
                    params.append("sendEmail=1");
                }
                isFirst = false;
            }
            queryStringParams = params.toString();
        }

        switch (userChoice) {
            case ("1"):
                response.sendRedirect("ListCities.html" + queryStringParams);
                break;
            case ("2"):
                response.sendRedirect("AddCity.html" + queryStringParams);
                break;
            case ("3"):
                response.sendRedirect("DeleteCity.html" + queryStringParams);
                break;
            default:
                //invalid response
                response.sendRedirect("index.html");
        }
    }
}

