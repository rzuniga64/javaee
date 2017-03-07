package com.servlets.models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *  MySQLConnectionBehavior.
 *  Extends DBUserInfo to give us the user id, password, and catalog.
 *  Implements ServerConnectionBehavior so the database manager can easily
 *  change this object and connect to MySQL correctly.
 */
public class MySQLServerConnectionBehavior extends DBUserInfo
        implements ServerConnectionBehavior {

    /**
     * Constructor.
     */
    public MySQLServerConnectionBehavior() {
        super();
    }

    /**
     * Overloaded constructor.
     * @param uid the user id
     * @param pwd the password
     * @param cat the category
     */
    public MySQLServerConnectionBehavior(final String uid,
                                         final String pwd,
                                         final String cat) {
        super(uid, pwd, cat);
    }

    /**
     * getConnection method.
     * @return the connection
     */
    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn = DriverManager.getConnection(getConnectionURL());
            return cn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get the connection URL.
     * @return the connection URL
     */
    @Override
    public String getConnectionURL() {
        return String.format("jdbc:mysql://localhost/%s?user=%s&password=%s",
                getCatalog(), getUserID(), getPassword());
    }

    /**
     * Get the connection details.
     * @return the connection details.
     */
    @Override
    public String getConnectionDetails() {
        return "MySQL Database Connection to " + getCatalog();
    }

    /**
     * getTableSchemaQuery method.
     * @return query method
     */
    @Override
    public String getTablesSchemaQuery() {
        return "select table_name from information_schema.tables "
                + "where table_schema = " + getCatalog();
    }
}
