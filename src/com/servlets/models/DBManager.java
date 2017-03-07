package com.servlets.models;
import java.io.Serializable;
import java.sql.*;

/**
 *  DBManager class. The main model that will be used in the application.
 *  Implements serializable in anticipation that this will go into session.
 *  Consists of User ID, password, and a catalog.
 *  Used to build our connection URL.
 *  The connection itself will be used locally.
 *  The server connection behavior is used to interchange the connection
 *  behavior so the application can connect to any database using this database
 *  manager with a correctly setup connection behavior.
 *
 */
public class DBManager implements Serializable {

    /** The connection. */
    private Connection cn = null;
    /** Server connection behavior. */
    private ServerConnectionBehavior scb = null;

    /** Default constructor. */
    public DBManager() { }

    /**
     *  Overloaded constructor.
     *  @param conBehavior conBehavior
     */
    public DBManager(final ServerConnectionBehavior conBehavior) {
        scb = conBehavior;
    }

    /**
     * Set the connection behavior.
     * @param value value
     * @return the set connection behavior
     */
    public boolean setConnectionBehavior(final ServerConnectionBehavior value) {
        if (value == null) {
            throw new IllegalArgumentException("Please use a valid connection"
                    + "behavior");
        }
        scb = value;
        return true;
    }

    /**
     * Is the connection open?
     * @return true if connection is open; false otherwise.
     */
    public boolean openConnection() {
        try {
            if (scb == null) {
                throw new IllegalArgumentException("Define "
                        + "a connection behavior");
            }
            if (cn != null) {
                closeConnection(false);
            }
            cn = scb.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (cn == null) {
            return false;
        }
        return true;
    }

    /**
     * Is the connection closed.
     * @param keepAlive keepAlive variable allows you to destroy the object
     * @return true if the connection is closed; false otherwise
     */
    public boolean closeConnection(final boolean keepAlive) {

        try {
            if (cn != null) {
                if (!cn.isClosed()) {
                    cn.close();
                }
            }
            if (!keepAlive) {
                cn = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Is there a connection?
     * @return true if connected; false otherwise
     */
    public boolean isConnected() {
        return cn != null;
    }

    /**
     * Pass in a query and create statement, execute the statement and closes
     * it.
     * @param query query
     * @return true if statement executed; false otherwise
     */
    public boolean ExecuteNonQuery(final String query) {
        try {
            Statement st = cn.createStatement();
            int i = st.executeUpdate(query);
            if (i == -1) {
                //log it
                return false;
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Get a result set back from the database using a prepared staetement and a
     * passed in query.
     * @param query query
     * @return the result set
     * @throws SQLException SQLException
     */
    public ResultSet ExecuteResultSet(final String query) throws SQLException {
        PreparedStatement st = cn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        return rs;
    }

    /**
     * Get the connection if we want to work with it outside of this object.
     * @return the connection
     */
    public Connection getConnection() {
        return cn;
    }

    /**
     * Get the connection URL.
     * @return the connection URL
     */
    public String getConnectionURL() {
        return scb.getConnectionURL();
    }

    /**
     * Get table schema query.
     * @return the table schemq query
     */
    public String getTablesSchemaQuery() {
        return scb.getTablesSchemaQuery();
    }
}
