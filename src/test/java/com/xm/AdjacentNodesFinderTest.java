package com.xm;

import com.xm.adjacentgetter.AdjacentNodesFinder;
import com.xm.adjacentgetter.KnightAdjacentNodesFinder;
import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.Piece;
import com.xm.utils.ChessBoardDimensions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static com.xm.model.data.Piece.createPieceFromCoordinates;
import static java.util.stream.Collectors.toUnmodifiableSet;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AdjacentNodesFinderTest {

    @Test
    void testKnightAdjacentGetter() {
        AdjacentNodesFinder<Piece> adjacentNodesFinder = new KnightAdjacentNodesFinder();

        Set<Node<Piece>> adjacent = adjacentNodesFinder.getAdjacent(new Node<>(createPieceFromCoordinates(
                Coordinates.valueOf(5, 1))));

        log.info("{}", adjacent);
        assertThat(adjacent).hasSameElementsAs(getExpectedNodes());
    }

    private Set<Node<Piece>> getExpectedNodes() {
        return Stream.of(
                        new Node<>(createPieceFromCoordinates(Coordinates.valueOf(3, 0))),
                        new Node<>(createPieceFromCoordinates(Coordinates.valueOf(3, 2))),
                        new Node<>(createPieceFromCoordinates(Coordinates.valueOf(4, 3))),
                        new Node<>(createPieceFromCoordinates(Coordinates.valueOf(6, 3))),
                        new Node<>(createPieceFromCoordinates(Coordinates.valueOf(7, 2))),
                        new Node<>(createPieceFromCoordinates(Coordinates.valueOf(7, 0)))
                )
                .filter(node -> isWithinBoard(node.getData().getCoordinates()))
                .collect(toUnmodifiableSet());
    }

    private boolean isWithinBoard(Coordinates coordinates) {
        return coordinates.x >= 0
                && coordinates.x < ChessBoardDimensions.X
                && coordinates.y >= 0
                && coordinates.y < ChessBoardDimensions.Y;
    }

}
