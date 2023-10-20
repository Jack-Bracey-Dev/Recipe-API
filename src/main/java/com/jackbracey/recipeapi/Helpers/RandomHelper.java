package com.jackbracey.recipeapi.Helpers;

import java.util.List;
import java.util.Random;

public class RandomHelper {

    public static Integer getRandomNumber(Integer min, Integer max) {
        return new Random().nextInt(max-min) + min;
    }

    public static Integer getRandomNumber(Integer max) {
        return getRandomNumber(0, max);
    }

    public static <T> T getRandomOptionFromList(List<T> options) {
        return options.get(getRandomNumber(options.size()-1));
    }

}
