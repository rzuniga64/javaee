package com.expressionlanguage.implicitobjects;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationStartup.
 * Used to populate a couple of attributes into the application we can access.
 */
@WebListener
public class ApplicationStartup implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ApplicationStartup() { }

    /**
     *  @param ctxt ctxt
     *  @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(final ServletContextEvent ctxt) {
        //add the application attribute
        ctxt.getServletContext().setAttribute("uid", "appUser");
        ctxt.getServletContext().setAttribute("pwd", "appUserPwd");
    }

    /**
     *  @param argo argo
     *  @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(final ServletContextEvent argo) { }
}
