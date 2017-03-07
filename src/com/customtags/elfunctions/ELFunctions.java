package com.customtags.elfunctions;

/**
 * Custom math functions implemented for use in JSP.
 */
public final class ELFunctions {

    /** Default constructor. */
    private ELFunctions() { }

    /**
     *  Square the input.
     *  @param x the value to square
     *  @return square of the value
     */
    public static double square(final double x) {
        return Math.pow(x, 2.0);
    }

    /**
     *  Cube the input.
     *  @param x the value to cube.
     *  @return cube of the value
     */
    public static double cube(final double x) {
        return Math.pow(x, 3.0);
    }

    /**
     *  Square root of the value.
     *  @param x the value to get the square root
     *  @return the square root of the value
     */
    public static double sqrt(final double x) {
        return Math.sqrt(x);
    }
}
