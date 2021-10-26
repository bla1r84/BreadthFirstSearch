package com.xm.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LetterToNumberMapper {

    public static final Map<String, Integer> letterToNumberMap = Map.of(
            "A", 0,
            "B", 1,
            "C", 2,
            "D", 3,
            "E", 4,
            "F", 5,
            "G", 6,
            "H", 7
    );

}