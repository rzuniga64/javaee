package com.javabeans.models;

import java.io.Serializable;

/** NavigationDetails model. */
public class NavigationDetails implements Serializable {

    /** Serial UID. */
    private static final long serialVersionUID = 1L;
    /** Link. */
    private String link;
    /** Text. */
    private String friendlyText;

    /** NavigationDetails method. */
    public NavigationDetails() { }

    /**
     *  Get the link.
     *  @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     *  Set the link.
     *  @param value the new link
     */
    public void setLink(final String value) {
        link = value;
    }

    /**
     *  Get the text.
     *  @return the text.
     */
    public String getText() {
        return friendlyText;
    }

    /**
     *  Set the text.
     *  @param value text
     */
    public void setText(final String value) {
        friendlyText = value;
    }

    /**
     *  Display data as a String.
     *  @return the data as a String
     */
    public String toString() {
        return String.format("Link: %s\tFriendly: %s\n", getLink(), getText());
    }
}
