package com.xm.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChessBoardDimensions {

    public static final int X;
    public static final int Y;
    private static final String CHESSBOARD_DIMENSIONS_X = "chessboard.dimensions.x";
    private static final String CHESSBOARD_DIMENSIONS_Y = "chessboard.dimensions.y";

    static {
        Properties properties = PropertiesReader.getApplicationProperties();

        X = NumberUtils.toInt(properties.getProperty(CHESSBOARD_DIMENSIONS_X));
        Y = NumberUtils.toInt(properties.getProperty(CHESSBOARD_DIMENSIONS_Y));

        if (X <= 0) {
            throw new IllegalArgumentException("Invalid value for X (must be positive)");
        }

        if (Y <= 0) {
            throw new IllegalArgumentException("Invalid value for Y (must be positive)");
        }
    }

}
