package com.jackbracey.recipeapi.Helpers;

import java.text.DecimalFormat;

public class RoundingHelper {

    public static Double RoundTo2DecimalPlaces(double input) {
        DecimalFormat format = new DecimalFormat("0.00");
        return Double.valueOf(format.format(input));
    }

}
