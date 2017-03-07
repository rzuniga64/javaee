package com.javabeans.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *  WebUserTest class.
 */
public class WebUserTest {

    /** Web user. */
    WebUser wu;
    /** User ID. */
    String uid = "authorized user";
    /** Password. */
    String pwd = "12@31x#C124";
    /** Authorization level. */
    int authLevel = 19;

    /**
     * Setup method.
     * @throws Exception Exception
     */
    @Before
    public void setUp() throws Exception {
        wu = new WebUser();
        wu.setUserId(uid);
        wu.setPassword(pwd);
        wu.setAuthLevel(authLevel);
    }

    /** Test the constructor. */
    @Test
    public void testConstructor() {
        assertNotNull("Default constructor not working for WebUser");
    }

    /** Test mutators and accessor methods. */
    @Test
    public void testMutatorsAndAccessors() {

        assertEquals("Value not set correctly for uid",
                uid, wu.getUserId());
        assertEquals("Value not set correctly for pwd",
                pwd, wu.getPassword());
        assertEquals("Value not set correctly for auth Level",
                authLevel,
                wu.getAuthLevel());
    }

    /** Test toString method. */
    @Test
    public void testToString() {

        String retStr = wu.toString();
        assertTrue("To String does not contain uid",
                retStr.contains(uid));
        assertTrue("To String does not contain pwd",
                retStr.contains(pwd));
        assertTrue("To String does not contain authLevel",
                retStr.contains(String.format("%d", authLevel)));
    }
}
