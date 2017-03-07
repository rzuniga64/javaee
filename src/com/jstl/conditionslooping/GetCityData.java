package com.jstl.conditionslooping;

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
import com.javabeans.models.City;

/**
 * Servlet implementation class GetCityData.
 */
@WebServlet(name = "GetCityData", urlPatterns = {"/getcitydata.do"})
public class GetCityData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCityData() {
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

        HttpSession s = request.getSession();
        //get the cities and direct on
        if (getServletContext().getAttribute("WorldDBManager") != null) {
            DBManager dbm = (DBManager) getServletContext().
                    getAttribute("WorldDBManager");
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    //log it
                    throw new IOException("Could not connect to database and "
                            + "open connection");
                }
            }

            //build a list of city objects using the query
            ArrayList<City> allCities = new ArrayList<City>();
            String query = DBWorldQueries.getCitiesByDistrictByPopulation();
            try {
                ResultSet rs = dbm.ExecuteResultSet(query);
                while (rs.next()) {
                    City c = new City();
                    c.setId(rs.getInt("ID"));
                    c.setName(rs.getString("Name"));
                    c.setCountryCode(rs.getString("CountryCode"));
                    c.setDistrict(rs.getString("District"));
                    c.setPopulation(rs.getInt("Population"));
                    allCities.add(c);
                }
                s.setAttribute("cityData", allCities);
            } catch (Exception ex) {
                //log it
                throw new IOException("Query could not be executed for get all "
                        + "cities");
            }
            response.sendRedirect("listCities.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
