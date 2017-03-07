package com.servlets.sessionlisteners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveUserTracking.
 *
 */
@WebListener
public class ActiveUserTracking implements HttpSessionListener {

    /** Number of active users. */
    private static int activeUsers;

    /**
     * Default constructor.
     */
    public ActiveUserTracking() { }

    /**
     * Keep track of active users.
     * @param hse hse
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(final HttpSessionEvent hse) {
        System.out.println("A new Session was created");
        activeUsers++;
    }

    /**
     * @param hse hse
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(final HttpSessionEvent hse) {
        System.out.println("An existing Session was destroyed");
        activeUsers--;
    }

    /**
     * Get the number of active users.
     * @return the number of active users
     */
    public static int getActiveUserCount() {
        return activeUsers;
    }
}
