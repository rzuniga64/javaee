package com.javabeans.models;

import java.io.Serializable;

/** CountryLanguage class. */
public class CountryLanguage implements Serializable {

    /** Default SerialID. */
    private static final long serialVersionUID = 1L;
    /** Country code. */
    private String countryCode;
    /** Language. */
    private String language;
    /** isOfficial. */
    private boolean isOfficial;
    /** Percentage. */
    private double percentage;

    /** Default constructor. */
    public CountryLanguage() { }

    /**
     *  Get country code.
     *  @return country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *  Set country code.
     *  @param value country code
     */
    public void setCountryCode(final String value) {
        countryCode = value;
    }

    /**
     *  Get language.
     *  @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *  Set language.
     *  @param value language
     */
    public void setLanguage(final String value) {
        language = value;
    }

    /**
     *  Get isOfficial.
     *  @return isOfficial
     */
    public boolean getIsOfficial() {
        return isOfficial;
    }

    /**
     *  Set isOfficial.
     *  @param value isOfficial
     */
    public void setIsOfficial(final boolean value) {
        isOfficial = value;
    }

    /**
     *  Get percentage.
     *  @return percentage as a double
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     *  Set percentage.
     *  @param value percentage
     */
    public void setPercentage(final double value) {
        percentage = value;
    }

    /**
     *  The CountryLanguage object.
     *  @return String representing CountryLanguage
     */
    public String toString() {

        return String.format("Country Code: %s\t"
                        + "Language: %s\tIs Official: %b\t"
                        + "Percentage: %.1f\n",
                getCountryCode(), getLanguage(),
                getIsOfficial(), getPercentage());
    }
}
