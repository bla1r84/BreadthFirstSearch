package com.xm.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Coordinates {

    public final int x;
    public final int y;

    public static Coordinates valueOf(int x, int y) {
        return new Coordinates(x, y);
    }

}