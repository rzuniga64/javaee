package com.servlets.models;

import java.sql.Connection;

/**
 * ServerConnectionBehavior allows polymorphic database connections.
 */
public interface ServerConnectionBehavior {

    /**
     * Get the connection.
     * @return a connection
     */
    Connection getConnection();

    /**
     * Actual connection parameters we need to make a new connection.
     * @return connection method
     */
    String getConnectionURL();

    /**
     * String to tell us what we are doing with connection.
     * @return connection details
     */
    String getConnectionDetails();

    /**
     * Simple check to see if connection by grabbing tables.
     * @return query method
     */
    String getTablesSchemaQuery();
}
