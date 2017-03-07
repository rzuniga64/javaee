package com.servlets.dbhelpers;

import javax.servlet.*;

import com.servlets.models.DBManager;
import com.servlets.models.MySQLServerConnectionBehavior;
import com.servlets.models.ServerConnectionBehavior;

/**
 *  DBManagerSetup class.
 *  For this to work set up a listener that sets this class as the listener
 *  class. We need to add a listener class entry in the deployment descriptor
 *  (web.xml) that points to this class.
 */
public class DBManagerSetup implements ServletContextListener {

    /** DBManager. */
    private DBManager dbm = null;

    /**
     * contextDestroyed method.
     * @param arg0 arg0
     */
    @Override
    public void contextDestroyed(final ServletContextEvent arg0) {

        //cleanup the connection when the context is destroyed
        if (dbm != null) {
            if (dbm.isConnected()) {
                dbm.closeConnection(false);
            }
        }
        dbm = null;
    }

    /**
     *  contextInitialized class.
     *  We want to use a Context DBManager across our entire application.
     *  We just need to grab that context servlet out of ServletContextEvent
     *  that is passed in and get the userid, password, and catalogue, create
     *  a new ServerConnectionBehavior, instantiate a DBManager, and put that
     *  manager into a context attribute.
     *  @param sce sce
     */
    @Override
    public void contextInitialized(final ServletContextEvent sce) {

        // access the servlet context from the event argument (renamed sce)
        // get db connect info from context init params
        ServletContext sc = sce.getServletContext();
        String uid = sc.getInitParameter("dbuserid");
        String pwd = sc.getInitParameter("dbuserpwd");
        String cat = sc.getInitParameter("dbinitcat");

        //set the scb for mySQL
        ServerConnectionBehavior scb =
                new MySQLServerConnectionBehavior(uid, pwd, cat);

        //create the manager, put the manager into a context attribute
        dbm = new DBManager(scb);

        //put the manager into the servlet context attributes for global use in
        // the application
        sc.setAttribute("WorldDBManager", dbm);

        System.out.println("WorldDBManager created and added to context");
    }
}
