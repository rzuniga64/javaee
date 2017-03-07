package com.servlets.contextlisteners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dbhelpers.DBWorldQueries;
import com.servlets.models.DBManager;

/**
 * Servlet implementation class ListCities.
 * Uses the DBManager class.
 */
@WebServlet(name = "ListCities", urlPatterns = "/listcities.do")
public class ListCities extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     *  @see HttpServlet#HttpServlet()
     */
    public ListCities() {
        super();
    }

    /**
     *  doGet method.
     *  The DBManager instantiation is now pulled from the context attribute
     *  created in DBManagerSetup. We don't have to recreate a DBManager every
     *  time we want to run a servlet that wants to connect to the database.
     *  The query has been moved into another helper to make it reusable.
     *
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

        // get the DBManager from context set in DBManagerSetup class.
        DBManager dbm = (DBManager) getServletContext().
                getAttribute("WorldDBManager");
        // generate the output in a StringBuilder
        StringBuilder sb = new StringBuilder("<html><body>");

        try {
            //connect to the db and open the connection
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    //massive failure, log it
                    sb.append("Could not connect to the database...");
                }
            }

            //ID NAME CountryCode District Population
            // get the cities into a table:
            sb.append("<table border=1>"
                    + "<tr><td>ID</td><td>NAME</td><td>COUNTRY_CODE</td>"
                    + "<td>DISTRICT</td><td>POPULATION</td></tr>");

            // is this MVC? NO.  Queries should be logic outside of the
            // controller. views should handle the results.  We clearly have a
            // way to go to get to MVC from here.
            String query = DBWorldQueries.getCitiesByDistrictByPopulation();
            ResultSet rs = dbm.ExecuteResultSet(query);
            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String ctry = rs.getString("CountryCode");
                String dist = rs.getString("District");
                int pop = rs.getInt("Population");

                sb.append("<tr><td>" + id + "</td>"
                        + "<td>" + name + "</td>"
                        + "<td>" + ctry + "</td>"
                        + "<td>" + dist + "</td>"
                        + "<td>" + pop + "</td></tr>");
            }
            sb.append("</table>");
        } catch (Exception e) {
            sb.append("<h1>ERROR: " + e.getMessage() + "</h1>");
        }
        sb.append("</body></html>");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(sb);
    }
}
