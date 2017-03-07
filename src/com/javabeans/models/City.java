package com.javabeans.models;

import java.io.Serializable;

/**
 *  City Java bean class.
 *  Needs to implement Serializable and have a default constructor.
 */
public class City implements Serializable {

    /** Default serial ID.*/
    private static final long serialVersionUID = 1L;
    /** The table id.*/
    private int id;
    /** Name. */
    private String name;
    /** Country code. */
    private String countryCode;
    /** District. */
    private String district;
    /** Population. */
    private int population;

    /** public default constructor. */
    public City() { }

    /**
     * Get the id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id.
     * @param value value
     */
    public void setId(final int value) {
        id = value;
    }

    /**
     * Get the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * @param value value
     */
    public void setName(final String value) {
        name = value;
    }

    /**
     * Get the country code.
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set the country code.
     * @param value value
     */
    public void setCountryCode(final String value) {
        countryCode = value;
    }

    /**
     * Get the district.
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     *
     * @param value value
     */
    public void setDistrict(final String value) {
        district = value;
    }

    /**
     * Get the population.
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Set the population.
     * @param value value
     */
    public void setPopulation(final int value) {
        population = value;
    }

    /**
     * Tostring method.
     * @return string representation of the data.
     */
    public String toString() {
        return String.format("Id: %d\tName: %s\tCountry Code: %s\t"
                        + "District: %s\tPopulation: %d\n",
        getId(), getName(), getCountryCode(), getDistrict(), getPopulation());
    }
}
