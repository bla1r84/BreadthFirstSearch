package com.xm.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YParser {

    private static YParser instance;

    private final Properties properties = PropertiesReader.getApplicationProperties();

    public int parseY(String yProperty) {
        int y = Integer.parseInt(properties.getProperty(yProperty));

        if (y <= 0 || y > ChessBoardDimensions.Y) {
            throw new IllegalArgumentException("Invalid " + yProperty + " given (" + y + ")");
        }

        return y - 1;
    }

    public static YParser getInstance() {
        if (instance == null) {
            instance = new YParser();
        }
        return instance;
    }

}
