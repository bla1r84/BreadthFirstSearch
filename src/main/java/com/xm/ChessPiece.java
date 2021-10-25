package com.xm;

import java.util.Set;
import java.util.function.Function;

public interface ChessPiece {

    Square getStart();
    Square getEnd();
    Function<CoordinatesPair, Set<CoordinatesPair>> getPossibleNextPositions();

}
