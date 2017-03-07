package com.servlets.dbhelpers;

/**
 * DBWorldQueries class.
 */
public final class DBWorldQueries {

    /** Default Constructor. */
    private DBWorldQueries() { }

    /**
     * Get the cities by district then by population.
     * @return the cities by district then by population
     */
    public static String getCitiesByDistrictByPopulation() {
        return "select * from city where CountryCode = 'USA' "
                + "order by District ASC, Population DESC";
    }

    /**
     * Get the countries by name.
     * @return the countries by name
     */
    public static String getCountriesByName() {
        return "select * from country "
                + "order by Name";
    }
}
