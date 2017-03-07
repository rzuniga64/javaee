package com.wrappers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Create a parameter inspector to intercept and capitalize a parameter if found
 * Needs to be implemented via a filter.
 *
 */
public class ParameterInspector extends HttpServletRequestWrapper {

    /**
     * ParameterINspector method.
     * @param request request
     */
    public ParameterInspector(final HttpServletRequest request) {
        super(request);
        //System.out.println("Constructed");
    }

    /**
     * Intercept requests to get parameters from the request.
     * @param p p
     * @return p
     */
    public String[] getParameterValues(final String p) {
        //get originals
        String[] values = super.getParameterValues(p);
        if (values == null) {
            return null;
        }
        ArrayList<String> newValues = new ArrayList<String>();

        // change all the text to Caps for parameter
        // interceptedParam
        for (String s : values) {
            if (p.equalsIgnoreCase("interceptedparam")) {
                s = s.toUpperCase();
            }
            newValues.add(s);
        }
        return (String[]) newValues.toArray();
    }

    /**
     *  Single param.
     *  @param p p
     *  @return p
     */
    public String getParameter(final String p) {
        String value = super.getParameter(p);
        if (value == null) {
            return null;
        }
        if (p.equalsIgnoreCase("interceptedparam")) {
            return value.toUpperCase();
        }
        return value;
    }

    /**
     *  Hijack a header if you want.
     * @param h h
     * @return h
     */
    public String getHeader(final String h) {
        return super.getHeader(h);
    }
}
