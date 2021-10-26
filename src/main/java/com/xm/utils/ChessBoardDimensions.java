package com.xm.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChessBoardDimensions {

    private static final String CHESSBOARD_DIMENSIONS_X = "chessboard.dimensions.x";
    private static final String CHESSBOARD_DIMENSIONS_Y = "chessboard.dimensions.y";

    public static final int X;
    public static final int Y;

    static {
        Properties properties = PropertiesReader.getApplicationProperties();

        X = NumberUtils.toInt(properties.getProperty(CHESSBOARD_DIMENSIONS_X));
        Y = NumberUtils.toInt(properties.getProperty(CHESSBOARD_DIMENSIONS_Y));
    }

}
