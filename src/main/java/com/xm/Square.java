package com.xm;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Square {

    @EqualsAndHashCode.Include
    public final int x;

    @EqualsAndHashCode.Include
    public final int y;

    private int depth;

    public static Square getDefaultSquare() {
        return new Square(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static Square getSquareFromCoordinatesPair(int x, int y, int depth) {
        return new Square(x, y, depth);
    }

}
