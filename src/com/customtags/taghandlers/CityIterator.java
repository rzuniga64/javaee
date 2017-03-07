package com.customtags.taghandlers;
import com.javabeans.models.City;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  CityIterator class.
 */
public class CityIterator extends SimpleTagSupport {

    /** Array of cities. */
    private ArrayList<City> cities;

    /**
     *  Mutator for City List.
     *  @param value the list of Cities to iterate
     */
    public void setCityList(final ArrayList<City> value) {

        cities = value;
    }

    /**
     *  doTag method.
     *  @throws JspException JspException
     *  @throws IOException IOException
     */
    public void doTag() throws JspException, IOException {

        for (City c : cities) {
            getJspContext().setAttribute("city", c);
            getJspBody().invoke(null);
        }
    }
}
