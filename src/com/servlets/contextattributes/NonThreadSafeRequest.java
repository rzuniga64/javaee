package com.servlets.contextattributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  DO NOT IMPLEMENT (NOT THREAD SAFE)
 *  Servlet implementation class NonThreadSafeRequest.
 *  Works at the request level. Once the request is done it is gone.
 *  This is not thread-safe even if we grab set the attribute before start of a
 *  long running process.
 *
 *  To see this run index.html and then copy the URL into a different browser.
 *  It works fine if each browser makes the request individually. But when run
 *  simultaneously both threads get the same context value which is wrong.
 */
@WebServlet(name = "/NonThreadSafeRequest",
            urlPatterns = {"/nonthreadsaferequest.do"})
public class NonThreadSafeRequest extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet()
     */
    public NonThreadSafeRequest() {
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

        // get the attribute and multiply by two to increase factor but pretend
        // this is a longer running process...
        StringBuilder msg = new StringBuilder("");
        msg.append("<html><body>");
        int currentSeed = (int) getServletContext().
                getAttribute("currentSeedValue");
        msg.append(String.format("Attribute Retrieved Value: %d<br>",
                currentSeed));

        currentSeed *= 2;

        //set the value in the REQUEST
        request.setAttribute("currentSeedValue", currentSeed);

        // set the value in the CONTEXT
        // getServletContext().setAttribute("currentSeedValue", currentSeed);

        // simulate a long running operation.
        try {
            Thread.sleep(5000);  //wait 5 seconds...
        } catch (InterruptedException e) {
            //do nothing...
        }

        // set the value in the CONTEXT
        getServletContext().setAttribute("currentSeedValue", currentSeed);

        // re-fetch the value after waiting from the REQUEST
        currentSeed = (int) request.getAttribute("currentSeedValue");
        msg.append(String.format("Request Attribute retrieved value after "
                + "process: %d<br>", currentSeed));

        //and from the CONTEXT
        currentSeed = (int) getServletContext().
                getAttribute("currentSeedValue");
        msg.append(String.format("Context Attribute retrieved value after "
                + "process: %d<br>", currentSeed));
        msg.append("</body></html>");

        //spit it out
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(msg);
    }
}
