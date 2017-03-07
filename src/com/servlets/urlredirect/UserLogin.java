package com.servlets.urlredirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  Servlet implementation class UserLogin..
 *
 *  Import javax.servlet.http.HttpSession. Get the session from the request
 *  object. Set attributes using the session.
 *
 *  Use encodeRedirectURL(URL) to redirect the response to the URL we want with
 *  the jsessionid.  So if cookies are enabled it will still work with the
 *  cookies. If cookies are disabled it falls back to use the jsessionid.
 *
 *  response.sendRedirect(response.
 *                  encodeRedirectURL("destinationpage.do"));
 */
@WebServlet(name = "userlogin", urlPatterns = {"/userlogin.do"})
public class UserLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
    }

    /**
     * doPost method.
     * @param request request
     * @param response response
     * @throws ServletException Servlet Exception
     * @throws IOException IOException
     * @see HttpServlet#doPost(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
                          throws ServletException, IOException {

        // here we would put some logic to validate the user.
        // simulate...
        String uid = "authorizeduser";
        int authLevel = 1;

        // assuming the user is valid, let's set some information into session
        // in this way, ALL jsp pages and servlets going forward can access the
        // value

        // to start a session, get the session from the request into a variable
        // add import javax.servlet.http.HttpSession;
        HttpSession session = request.getSession();
        // just like other examples, use the session variable to get and set
        // attributes
        session.setAttribute("userName", uid);
        session.setAttribute("userAuthLevel", authLevel);

        //set our redirect URL to have the jsession id in play
        if (authLevel < 1 || uid == null || uid == "") {
            // send back to calling page or forward to
            // unauthorized notification

            //response.sendRedirect("login.html");
            response.sendRedirect(response.encodeRedirectURL("login.html"));
        } else {
            // forward to requested page or menu page/home page with
            // authorization
            //response.sendRedirect("destinationpage.do");
            response.sendRedirect(response.encodeRedirectURL("destinationpage.do"));
        }
    }
}
