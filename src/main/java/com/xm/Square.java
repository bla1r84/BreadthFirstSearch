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
    public final CoordinatesPair coordinates;

    private int depth;

    public static Square createDefaultSquare() {
        return new Square(CoordinatesPair.getDefaultCoordinates(), Integer.MAX_VALUE);
    }

    public static Square createSquareFromCoordinates(int x, int y, int depth) {
        return new Square(CoordinatesPair.createPairFromCoordinates(x, y), depth);
    }

    public int getX() {
        return coordinates.x;
    }

    public int getY() {
        return coordinates.y;
    }

}
