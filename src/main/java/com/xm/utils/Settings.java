package com.xm.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Properties;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Settings {

    private static final String START_X = "piece.start.x";
    private static final String START_Y = "piece.start.y";
    private static final String TARGET_X = "piece.target.x";
    private static final String TARGET_Y = "piece.target.y";

    public static final int MAX_ALLOWED_MOVES;
    public static final Pair<Integer, Integer> START;
    public static final Pair<Integer, Integer> TARGET;

    static {
        Properties properties = PropertiesReader.getApplicationProperties();

        MAX_ALLOWED_MOVES = toInt(properties.getProperty("max-allowed-moves"));
        START = Pair.of(toInt(properties.getProperty(START_X)), toInt(properties.getProperty(START_Y)));
        TARGET = Pair.of(toInt(properties.getProperty(TARGET_X)), toInt(properties.getProperty(TARGET_Y)));
    }

}
