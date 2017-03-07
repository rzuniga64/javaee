package com.javabeans.models;

import java.io.Serializable;

/**
 *  WebUser Java bean class.
 *  Needs to implement Serializable and have a default constructor.
 */
public class WebUser implements Serializable {

    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** User ID. */
    private String uid;
    /** Password. */
    private String pwd;
    /** Authorization level. */
    private int authLevel;

    /** Constructor. */
    public WebUser() { }

    /**
     *  Get the user ID.
     *  @return the user id
     */

    public String getUserId() {
        return uid;
    }

    /**
     *  Set the user ID.
     *  @param value userid
     */
    public void setUserId(final String value) {
        uid = value;
    }

    /**
     *  Get the password.
     *  @return the password
     */
    public String getPassword() {
        return pwd;
    }

    /**
     *  Set the passoword.
     *  @param value password
     */
    public void setPassword(final String value) {
        pwd = value;
    }

    /**
     *  Get the authorization level.
     *  @return the authorization level.
     */
    public int getAuthLevel() {
        return authLevel;
    }

    /**
     *  Set the authorization level.
     *  @param value authorization level
     */
    public void setAuthLevel(final int value) {
        authLevel = value;
    }

    /**
     *  ToString method.
     *  @return the data as a String
     */
    public String toString() {
        return String.format("UID: %s\tPWD: %s\tAuthLevel: %d\n",
                getUserId(), getPassword(), getAuthLevel());
    }
}
