package com.javabeans.models;

import java.io.Serializable;

/**
 *  Country Java bean class.
 *  Needs to implement Serializable and have a default constructor.
 */
public class Country implements Serializable {

    /** Default serial ID.*/
    private static final long serialVersionUID = 1L;
    /** Code.*/
    private String code;
    /** Name.*/
    private String name;
    /** Continent.*/
    private String continent;
    /** Region.*/
    private String region;
    /** Surface area.*/
    private double surfaceArea;
    /** Independence year. */
    private int indepYear;
    /** Population. */
    private int population;
    /** Life expectancy.*/
    private double lifeExpectancy;
    /** Gross National Product. */
    private double gnp;
    /** Old gross national product.*/
    private double gnpOld;
    /** Local name.*/
    private String localName;
    /** Government form.*/
    private String governmentForm;
    /** Head of state.*/
    private String headOfState;
    /** Capital.*/
    private String capital;
    /** Code2.*/
    private String code2;

    /** Default constructor. */
    public Country() { }

    /**
     *  Get Code.
     *  @return code
     */
    public String getCode() {
        return code;
    }

    /**
     *  Set code.
     *  @param value code
     */
    public void setCode(final String value) {
        code = value;
    }

    /**
     *  Get name.
     *  @return name
     */
    public String getName() {
        return name;
    }

    /**
     *  Set name.
     *  @param value name
     */
    public void setName(final String value) {
        name = value;
    }

    /**
     *  Get continent.
     *  @return continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     *  Set continent.
     *  @param value continent
     */
    public void setContinent(final String value) {
        continent = value;
    }

    /**
     *  Get region.
     *  @return regiion
     */
    public String getRegion() {
        return region;
    }

    /**
     * Set region.
     * @param value region
     */
    public void setRegion(final String value) {
        region = value;
    }

    /**
     *  Get surface area.
     * @return surface area
     */
    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     *  Set surface area.
     * @param value surface area
     */
    public void setSurfaceArea(final double value) {
        surfaceArea = value;
    }

    /**
     *  Get independence year.
     * @return independence year
     */
    public int getIndepYear() {
        return indepYear;
    }

    /**
     *  Set indepence year.
     * @param value independence year
     */
    public void setIndepYear(final int value) {
        indepYear = value;
    }

    /**
     *  Get population.
     *  @return population
     */
    public int getPopulation() {
        return population;
    }

    /**
     *  Set population.
     *  @param value population
     */
    public void setPopulation(final int value) {
        population = value;
    }

    /**
     *  Get life expectancy.
     * @return life excpectancy
     */
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     *  Set life expectancy.
     * @param value life expectancy
     */
    public void setLifeExpectancy(final double value) {
        lifeExpectancy = value;
    }

    /**
     *  Get gross national product.
     *  @return gross national product.
     */
    public double getGnp() {
        return gnp;
    }

    /**
     *  Set gross national product.
     *  @param value gross national prodcut.
     */
    public void setGnp(final double value) {
        gnp = value;
    }

    /**
     *  Get od gross national product.
     *  @return old gross national product.
     */
    public double getGnpOld() {
        return gnpOld;
    }

    /**
     *  Set old gross national product.
     *  @param value old gross national product
     */
    public void setGnpOld(final double value) {
        gnpOld = value;
    }

    /**
     *  Get local name.
     *  @return local name
     */
    public String getLocalName() {
        return localName;
    }

    /**
     *  Set local name.
     *  @param value local name
     */
    public void setLocalName(final String value) {
        localName = value;
    }

    /**
     *  Get government form.
     * @return government form.
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     *  Set government form.
     *  @param value government form
     */
    public void setGovernmentForm(final String value) {
        governmentForm = value;
    }

    /**
     *  Get head of state.
     *  @return head of state
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     *  Set head of state.
     *  @param value head of state
     */
    public void setHeadOfState(final String value) {
        headOfState = value;
    }

    /**
     *  Get capiatal.
     *  @return capital
     */
     public String getCapital() {
         return capital;
     }

    /**
     *  Set capital.
     *  @param value capital
     */
    public void setCapital(final String value) {
        capital = value;
    }

    /**
     *  Get code2.
     *  @return ocde2
     */
    public String getCode2() {
        return code2;
    }

    /**
     *  Set code2.
     *  @param value code2
     */
    public void setCode2(final String value) {
        code2 = value;
    }

    /**
     * toString method.
     * @return data as a string
     */
    public String toString() {

        return String.format(
                "Code: %s\tName: %s\tContinent: %s\tRegion%s\t "
            + "Surface Area: %.1f\tIndependence Year: %d\tPopulation: %d\t"
            + "Life Expectancy: %.1f\tGNP: %.1f\tGNP OLD: %.1f\tLocal Name: %s\t"
            + "GovernmentForm: %s\tHead Of State: %s\tCapital %s\tCode2: %s\n",
                getCode(),
                getName(),
                getContinent(),
                getRegion(),
                getSurfaceArea(),
                getIndepYear(),
                getPopulation(),
                getLifeExpectancy(),
                getGnp(),
                getGnpOld(),
                getLocalName(),
                getGovernmentForm(),
                getHeadOfState(),
                getCapital(),
                getCode2());
    }
}
