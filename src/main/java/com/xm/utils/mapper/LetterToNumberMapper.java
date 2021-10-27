package com.xm.utils.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LetterToNumberMapper {

    private static final Map<String, Integer> letterToNumberMap = Map.of(
            "A", 0,
            "B", 1,
            "C", 2,
            "D", 3,
            "E", 4,
            "F", 5,
            "G", 6,
            "H", 7
    );

    public static Map<String, Integer> getLetterToNumberMap() {
        return new HashMap<>(letterToNumberMap);
    }

}
