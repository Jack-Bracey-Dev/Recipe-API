package com.jackbracey.recipeapi.Helpers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberHelper {

    public static List<Integer> getNumberRangeList(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

}
