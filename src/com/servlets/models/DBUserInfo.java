package com.servlets.models;

/**
 * DBUserInfo class.
 */
public abstract class DBUserInfo {

    /** uid. */
    private String uid;
    /** pwd. */
    private String pwd;
    /** cat. */
    private String cat;

    /** Constructor.*/
    public DBUserInfo() { }

    /**
     * Overloaded constructor.
     * @param userID user id
     * @param password password
     * @param catalog catalog
     */
    public DBUserInfo(final String userID,
                      final String password,
                      final String catalog) {
        uid = userID;
        pwd = password;
        cat = catalog;
    }

    /**
     * Get the user id.
     * @return the user id
     */
    public String getUserID() {
        return uid;
    }

    /**
     * Set the user id.
     * @param value value
     */
    public void setUserID(final String value) {
        uid = value;
    }

    /**
     * Get the password.
     * @return teh password
     */
    public String getPassword() {
        return pwd;
    }

    /**
     * Set the password.
     * @param value the new passoword
     */
    public void setPassword(final String value) {
        pwd = value;
    }

    /**
     * Get the catalog.
     * @return the catalog
     */
    public String getCatalog() {
        return cat;
    }

    /**
     * Set the catalog.
     * @param catalog catalog
     */
    public void setCatalog(final String catalog) {
        cat = catalog;
    }
}
