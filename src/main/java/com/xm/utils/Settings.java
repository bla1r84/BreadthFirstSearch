package com.xm.utils;

import com.xm.model.Coordinates;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import static com.xm.utils.Constants.*;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Settings {

    public static final int MAX_ALLOWED_MOVES;
    public static final Coordinates START;
    public static final Coordinates TARGET;

    static {
        XParser xParser = XParser.getInstance();
        YParser yParser = YParser.getInstance();

        MAX_ALLOWED_MOVES = toInt(PropertiesReader.getApplicationProperties().getProperty("max-allowed-moves"));

        int startX = xParser.parseX(START_X);
        int startY = yParser.parseY(START_Y);

        int targetX = xParser.parseX(TARGET_X);
        int targetY = yParser.parseY(TARGET_Y);

        START = Coordinates.valueOf(startX, startY);
        TARGET = Coordinates.valueOf(targetX, targetY);
    }


}
