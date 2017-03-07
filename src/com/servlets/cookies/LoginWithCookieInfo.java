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
 *  Servlet implementation class LoginWithCookieInfo.
 *
 *  Simulate if the user want to store the userid and password information in a
 *  cookie so he won't have to re-type the information. First pull from the
 *  cookie to see if the credentials are stored in the cookie array.
 *
 *  in the future, we'll learn how to do similar things right in a jsp so this
 *  step won't be needed. For now we will simulate that activity to study cookies
 *  here, we will try to pull information from a cookie if the cookie exists,
 *  we will then spit out the page with information populated.  if the cookie
 *  doesn't exist we'll just show the screen with no data.  An option to save
 *  info will always be shown. Because it would be incredibly horrible to show
 *  password information as a query string value print out the page (rather
 *  than redirect to an html login). Soon, with JSP, we'll learn better ways to
 *  do all of this....
 */
@WebServlet(name = "LoginWithCookieInfo",
            urlPatterns = {"/loginwithcookieinfo.do"})
public class LoginWithCookieInfo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet()
     */
    public LoginWithCookieInfo() {
        super();
    }

    /**
     * doPost method.
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     * @see HttpServlet#doPost(HttpServletRequest request,
     *       HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {

        String uid = ""; //populate with empty string so can use no matter what
        String pwd = ""; //same as uid

        // attempt to pull information from a cookie:
        // import javax.servlet.http.Cookie;
        Cookie[] mycookies = request.getCookies();

        if (mycookies != null) {
            for (Cookie c : mycookies) {
                if (c.getName().equalsIgnoreCase("credentials_uid")) {
                    //set the uid from cookie value
                    uid = c.getValue();
                } else if (c.getName().equalsIgnoreCase("credentials_pwd")) {
                    //set the pwd from cookie value
                    pwd = c.getValue();
                }
            }
        }

        //build the page
        StringBuilder sb = new StringBuilder("");
        sb.append("<html><body>");
        sb.append("<form id='frmLogin' name='frmLogin' "
                + "action='userlogincookies.do' "
                + "method='post'>");
        sb.append("<table>");
        sb.append("<tr><td><span>Username:</span></td>"
                + "<td><input type='text' name='userID' value='" + uid
                + "'/></td></tr>");
        sb.append("<tr><td><span>Password:</span></td>"
                + "<td><input type='password' name='pwd'  value='" + pwd
                + "'/></td></tr>");
        sb.append("<tr><td colspan='2' align='right'>"
                + "<input type='checkbox' name='remember' />"
                + "Remember Me</td></tr>");
        sb.append("<tr><td colspan='2' align='right'>"
                + "<input name='loginbutton' type='submit' value='Log In' />");
        sb.append("</table>");
        sb.append("</form>");
        sb.append("</body></html>");

        //spit out the login page:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(sb.toString());
    }
}
