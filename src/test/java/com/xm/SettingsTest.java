package com.xm;

import com.xm.utils.ChessBoardDimensions;
import com.xm.utils.PropertiesReader;
import com.xm.utils.mapper.LetterToNumberMapper;
import com.xm.utils.parser.XParser;
import com.xm.utils.parser.YParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static com.xm.utils.Constants.START_X;
import static com.xm.utils.Constants.START_Y;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SettingsTest {

    private static Properties properties;

    @BeforeAll
    static void setup() {
        properties = PropertiesReader.getApplicationProperties();
    }

    @Test
    void testXParser() {
        XParser xParser = XParser.getInstance();

        String propStartX = properties.getProperty(START_X);
        log.info("propStartX: {}", propStartX);

        int startX = xParser.parseX(START_X);
        log.info("startX: {}", startX);

        if (!LetterToNumberMapper.getLetterToNumberMap().containsKey(propStartX)) {
            assertThat(startX).isEqualTo(NumberUtils.toInt(propStartX) - 1);
        } else {
            assertThat(startX).isBetween(0, 7);
        }
    }

    @Test
    void testYParserIsSingleton() {
        YParser yParser1 = YParser.getInstance();
        YParser yParser2 = YParser.getInstance();

        log.info("{}", yParser1);
        log.info("{}", yParser2);
        assertThat(yParser1).isEqualTo(yParser2);
    }

    @Test
    void testYParser() {
        YParser yParser = YParser.getInstance();
        String propStartY = properties.getProperty(START_Y);
        log.info("propStartY: {}", propStartY);

        int startY = yParser.parseY(START_Y);
        log.info("startY: {}", startY);

        assertThat(startY).isBetween(0, ChessBoardDimensions.Y);
    }

}
