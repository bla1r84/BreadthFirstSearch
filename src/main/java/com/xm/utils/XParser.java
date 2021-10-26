package com.xm.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Properties;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class XParser {

    private static XParser instance;

    private final Properties properties = PropertiesReader.getApplicationProperties();

    public int parseX(String xProperty) {
        String xFromProperties = properties.getProperty(xProperty);

        if (!LetterToNumberMapper.letterToNumberMap.containsKey(xFromProperties)) {
            int x = toInt(xFromProperties);
            if (x <=0 || x > ChessBoardDimensions.X) {
                throw new IllegalArgumentException("Invalid " + xProperty + " given (" + x + "). Must be between 0" +
                        " and " + ChessBoardDimensions.X);
            }
        }

        return LetterToNumberMapper.letterToNumberMap.getOrDefault(
                properties.getProperty(xProperty),
                toInt(properties.getProperty(xProperty)) - 1);
    }

    public static XParser getInstance() {
        if (instance == null) {
            instance = new XParser();
        }
        return instance;
    }

}
