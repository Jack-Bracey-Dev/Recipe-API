package com.jackbracey.recipeapi.Helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundingHelperTests {

    @Test
    void shouldReturnDoubleRoundedDownTo2DP() {
        double input = 123.12454;
        Assertions.assertEquals(123.12, RoundingHelper.RoundTo2DecimalPlaces(input));
    }

    @Test
    void shouldReturnDoubleRoundedUpTo2DP() {
        double input = 123.12554;
        Assertions.assertEquals(123.13, RoundingHelper.RoundTo2DecimalPlaces(input));
    }

}
