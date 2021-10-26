package com.xm;

import com.xm.adjacentgetter.AdjacentGetter;
import com.xm.adjacentgetter.KnightAdjacentGetter;
import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.piece.Knight;
import com.xm.utils.ChessBoardDimensions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableSet;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AdjacentGetterTest {

    @Test
    void testKnightAdjacentGetter() {
        AdjacentGetter<Knight> adjacentGetter = new KnightAdjacentGetter();
        Set<Node<Knight>> adjacent = adjacentGetter.getAdjacent(new Node<>(new Knight(Coordinates.valueOf(5, 1))));
        log.info("{}", adjacent);
        assertThat(adjacent).hasSameElementsAs(getExpectedNodes());
    }

    private Set<Node<Knight>> getExpectedNodes() {
        return Stream.of(
                        new Node<>(new Knight(Coordinates.valueOf(3, 0))),
                        new Node<>(new Knight(Coordinates.valueOf(3, 2))),
                        new Node<>(new Knight(Coordinates.valueOf(4, 3))),
                        new Node<>(new Knight(Coordinates.valueOf(6, 3))),
                        new Node<>(new Knight(Coordinates.valueOf(7, 2))),
                        new Node<>(new Knight(Coordinates.valueOf(7, 0)))
                )
                .filter(node -> isWithinBoard(node.getPiece().getCoordinates()))
                .collect(toUnmodifiableSet());
    }

    private boolean isWithinBoard(Coordinates coordinates) {
        return coordinates.x >= 0
                && coordinates.x < ChessBoardDimensions.X
                && coordinates.y >= 0
                && coordinates.y < ChessBoardDimensions.Y;
    }

}
