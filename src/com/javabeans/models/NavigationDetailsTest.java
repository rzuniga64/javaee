package com.javabeans.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/** NavigationDetailsTest. */
public class NavigationDetailsTest {

    /** Navigation details.*/
    NavigationDetails nd;
    /** Link. */
    String link = "http://www.mysite.com";
    /** Text. */
    String text = "My Site";

    /**
     * setUp method.
     * @throws Exception Exception
     */
    @Before
    public void setUp() throws Exception {
        nd = new NavigationDetails();
        nd.setLink(link);
        nd.setText(text);
    }

    /** Test the constructor. */
    @Test
    public void testConstructor() {
        assertNotNull("Default constructor not working for Navigation "
                + "Details");
    }

    /** Test mutators and accessors. */
    @Test
    public void testMutatorsAndAccessors() {
        assertEquals("Value not set correctly for link",
                link, nd.getLink());
        assertEquals("Value not set correctly for text",
                text, nd.getText());
    }

    /** Test toString. */
    @Test
    public void testToString() {
        String retStr = nd.toString();
        assertTrue("To String does not contain link",
                retStr.contains(link));
        assertTrue("To String does not contain text",
                retStr.contains(text));
    }
}
