package com.xm.utils;

import com.xm.exceptions.IORuntimeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesReader {

    private static final String PROPERTIES_FILENAME = "application.properties";

    public static Properties getApplicationProperties() {
        InputStream in = ChessBoardDimensions.class.getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return properties;
    }

}
