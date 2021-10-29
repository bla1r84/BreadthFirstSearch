package com.xm;

import com.xm.model.Coordinates;
import com.xm.model.data.Knight;
import com.xm.utils.ChessBoardDimensions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static com.xm.model.data.Knight.createPieceFromCoordinates;
import static java.util.stream.Collectors.toUnmodifiableSet;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AdjacentNodesFinderTest {

    @Test
    void testKnightAdjacentGetter() {
        Set<Knight> adjacent = createPieceFromCoordinates(Coordinates.valueOf(5, 1)).getAdjacent();

        log.info("{}", adjacent);
        assertThat(adjacent).hasSameElementsAs(getExpectedNodes());
    }

    private Set<Knight> getExpectedNodes() {
        return Stream.of(
                        createPieceFromCoordinates(Coordinates.valueOf(3, 0)),
                        createPieceFromCoordinates(Coordinates.valueOf(3, 2)),
                        createPieceFromCoordinates(Coordinates.valueOf(4, 3)),
                        createPieceFromCoordinates(Coordinates.valueOf(6, 3)),
                        createPieceFromCoordinates(Coordinates.valueOf(7, 2)),
                        createPieceFromCoordinates(Coordinates.valueOf(7, 0)))
                .filter(knight -> isWithinBoard(knight.getCoordinates()))
                .collect(toUnmodifiableSet());
    }

    private boolean isWithinBoard(Coordinates coordinates) {
        return coordinates.x >= 0
                && coordinates.x < ChessBoardDimensions.X
                && coordinates.y >= 0
                && coordinates.y < ChessBoardDimensions.Y;
    }

}
