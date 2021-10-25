package com.xm;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class CoordinatesPair {

    public final int x;
    public final int y;

    public static CoordinatesPair getDefaultCoordinates() {
        return new CoordinatesPair(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static CoordinatesPair createPairFromCoordinates(int x, int y) {
        return new CoordinatesPair(x, y);
    }

}
