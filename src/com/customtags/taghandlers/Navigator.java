package com.customtags.taghandlers;
import com.javabeans.models.NavigationDetails;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  Navigator class. Need to extend SimpleTagSupport so it can be run as a tag.
 */
public class Navigator extends SimpleTagSupport {

    /** Array of links. */
    private ArrayList<NavigationDetails> links;

    /** CreateNavigationLinks method. */
    private void CreateNavigationLinks() {
        links = new ArrayList<NavigationDetails>();

        NavigationDetails nd = new NavigationDetails();
        nd.setLink("index.jsp");
        nd.setText("Home");
        links.add(nd);

        nd = new NavigationDetails();
        nd.setLink("login.jsp");
        nd.setText("Login");
        links.add(nd);

        nd = new NavigationDetails();
        nd.setLink("listCities.jsp");
        nd.setText("View Cities");
        links.add(nd);

        nd = new NavigationDetails();
        nd.setLink("listCountries.jsp");
        nd.setText("View Countries");
        links.add(nd);

        nd = new NavigationDetails();
        nd.setLink("signout.do");
        nd.setText("Sign Out");
        links.add(nd);

        nd = new NavigationDetails();
        nd.setLink("invalidatesessionandremovecookies.do");
        nd.setText("Clear All User Data");
        links.add(nd);
    }

    /**
     * doTag method. Use a tag to display the links on our page.
     * @throws JspException JspException
     * @throws IOException IOException
     */
    public void doTag() throws JspException, IOException {
        //create the links
        CreateNavigationLinks();

        //iterate the links to the page
        for (NavigationDetails nd : links) {

            getJspContext().setAttribute("navdetails", nd);
            getJspBody().invoke(null);
        }
    }
}
