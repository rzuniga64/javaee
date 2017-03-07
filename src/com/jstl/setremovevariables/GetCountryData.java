package com.jstl.setremovevariables;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlets.dbhelpers.DBWorldQueries;
import com.servlets.models.DBManager;
import com.javabeans.models.Country;

/**
 * Servlet implementation class GetCountryData.
 */
@WebServlet(name = "GetCountryData", urlPatterns = {"/getcountrydata.do"})
public class GetCountryData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet()
     */
    public GetCountryData() {
        super();
    }

    /**
     * doGet method.
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     * @see HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {

        //make sure user is logged in
        String target = "";
        HttpSession s = request.getSession();
        if (s.getAttribute("authorized_user") != null) {

            //get the countries and direct on
            if (getServletContext().getAttribute("WorldDBManager") != null) {
                DBManager dbm = (DBManager) getServletContext().
                        getAttribute("WorldDBManager");
                if (!dbm.isConnected()) {
                    if (!dbm.openConnection()) {
                        //log it
                        throw new IOException("Could not connect to database "
                                + "and open connection");
                    }
                }

                //build a list of country objects using the query
                ArrayList<Country> allCountries = new ArrayList<Country>();
                String query = DBWorldQueries.getCountriesByName();
                try {
                    ResultSet rs = dbm.ExecuteResultSet(query);
                    while (rs.next()) {
                        Country c = new Country();
                        c.setCapital(rs.getString("Capital"));
                        c.setCode(rs.getString("Code"));
                        c.setCode2(rs.getString("Code2"));
                        c.setContinent(rs.getString("Continent"));
                        c.setGnp(rs.getDouble("GNP"));
                        c.setGnpOld(rs.getDouble("GNPOld"));
                        c.setGovernmentForm(rs.getString("GovernmentForm"));
                        c.setHeadOfState(rs.getString("HeadOfState"));
                        c.setIndepYear(rs.getInt("IndepYear"));
                        c.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
                        c.setLocalName(rs.getString("LocalName"));
                        c.setName(rs.getString("Name"));
                        c.setPopulation(rs.getInt("Population"));
                        c.setRegion(rs.getString("Region"));
                        c.setSurfaceArea(rs.getDouble("SurfaceArea"));
                        allCountries.add(c);
                        s.setAttribute("countryData", allCountries);
                    }
                } catch (Exception ex) {
                    //log it
                    throw new IOException("Query could not be executed for get "
                            + "all countries by name");
                }
                target = "listCountries.jsp";
            }
        } else {
            target = "login.jsp?dest=listCountries";
        }
        response.sendRedirect(target);
    }

    /**
     * doGet method.
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     * @see HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request,
                         final HttpServletResponse response)
                         throws ServletException, IOException {
        doGet(request, response);
    }
}
