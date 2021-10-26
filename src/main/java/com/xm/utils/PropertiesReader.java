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

    private static Properties applicationProperties;

    public static Properties getApplicationProperties() {
        if (applicationProperties == null) {
            InputStream in = ChessBoardDimensions.class.getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
            applicationProperties = new Properties();
            try {
                applicationProperties.load(in);
            } catch (IOException e) {
                throw new IORuntimeException(e);
            }
        }
        return applicationProperties;
    }

}
