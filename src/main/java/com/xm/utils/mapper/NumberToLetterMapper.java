package com.xm.utils.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberToLetterMapper {

    private static final Map<Integer, String> numberToLetterMap = Map.of(
            0, "A",
            1, "B",
            2, "C",
            3, "D",
            4, "E",
            5, "F",
            6, "G",
            7, "H"
    );

    public static Map<Integer, String> getNumberToLetterMap() {
        return new HashMap<>(numberToLetterMap);
    }

}
