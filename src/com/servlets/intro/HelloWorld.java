package com.servlets.intro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  HelloWorld Servlet.
 *  The Servlet Deployment Descriptor (WEB-INF/web.xml) can be used to configure
 *  the Servlet and override the @WebServlet annotation.
 *
 *  For example, the url-pattern can be configured:
 *
 *  servlet>
 *      servlet-name> HelloWorld& servlet-name>
 *      servlet-class> com.servlets.intro.HelloWorld servlet-class>
 *  servlet>
 *  servlet-mapping>
 *       servlet-name> HelloWorld servlet-name>
 *       url-pattern> /helloworld.do url-pattern>
 *  servlet-mapping>
 *
 *  So the URL pattern would be '/helloword.do' instead of '/HelloWorld'.
 */
@WebServlet(name = "HelloWorld", urlPatterns = {"/HelloWorld"})
public class HelloWorld extends HttpServlet {

    /**
     *
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("text/html");
        // get access to response so we can print output in the browser.
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align='center'>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
