package com.xm;

import java.util.Set;
import java.util.function.Function;

public class Knight {

    public static Function<CoordinatesPair, Set<CoordinatesPair>> getPossibleNextPositions() {
        return pair -> Set.of(
                new CoordinatesPair(pair.x + 2, pair.y + 1),
                new CoordinatesPair(pair.x + 1, pair.y + 2),
                new CoordinatesPair(pair.x - 1, pair.y + 2),
                new CoordinatesPair(pair.x - 2, pair.y + 1),
                new CoordinatesPair(pair.x - 2, pair.y - 1),
                new CoordinatesPair(pair.x - 1, pair.y - 2),
                new CoordinatesPair(pair.x + 1, pair.y - 2),
                new CoordinatesPair(pair.x + 2, pair.y - 1)
        );
    }

}
