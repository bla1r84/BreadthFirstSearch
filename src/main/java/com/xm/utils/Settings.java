package com.xm.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Settings {

    public static final int MAX_ALLOWED_MOVES = 6;

    public static final Pair<Integer, Integer> START = Pair.of(0, 0);
    public static final Pair<Integer, Integer> TARGET = Pair.of(7, 7);

}
