package com.xm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.function.Function;

import static com.xm.CoordinatesPair.createPairFromCoordinates;

@RequiredArgsConstructor
@Getter
public class Knight implements ChessPiece {

    private final Square start;
    private final Square end;

    @Override
    public Function<CoordinatesPair, Set<CoordinatesPair>> getPossibleNextPositions() {
        return pair -> Set.of(
                createPairFromCoordinates(pair.x + 2, pair.y + 1),
                createPairFromCoordinates(pair.x + 1, pair.y + 2),
                createPairFromCoordinates(pair.x - 1, pair.y + 2),
                createPairFromCoordinates(pair.x - 2, pair.y + 1),
                createPairFromCoordinates(pair.x - 2, pair.y - 1),
                createPairFromCoordinates(pair.x - 1, pair.y - 2),
                createPairFromCoordinates(pair.x + 1, pair.y - 2),
                createPairFromCoordinates(pair.x + 2, pair.y - 1)
        );
    }

}
