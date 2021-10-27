package com.xm.utils.parser;

import com.xm.utils.ChessBoardDimensions;
import com.xm.utils.PropertiesReader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YParser {

    private static YParser instance;

    private final Properties properties = PropertiesReader.getApplicationProperties();

    public static YParser getInstance() {
        if (instance == null) {
            instance = new YParser();
        }
        return instance;
    }

    public int parseY(String yProperty) {
        int y = Integer.parseInt(properties.getProperty(yProperty));

        if (y <= 0 || y > ChessBoardDimensions.Y) {
            throw new IllegalArgumentException("Invalid " + yProperty + " given (" + y + "). Must be between 0" +
                    " and " + ChessBoardDimensions.Y);
        }

        return y - 1;
    }

}
