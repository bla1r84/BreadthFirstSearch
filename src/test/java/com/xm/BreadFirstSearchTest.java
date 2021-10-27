package com.xm;

import com.xm.adjacentgetter.AdjacentNodesFinder;
import com.xm.adjacentgetter.KnightAdjacentNodesFinder;
import com.xm.adjacentgetter.MyIntegerAdjacentNodesFinder;
import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.MyInteger;
import com.xm.model.data.Piece;
import com.xm.services.Graph;
import com.xm.utils.CoordinatesPathLogger;
import com.xm.utils.Settings;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static com.xm.model.data.Piece.createPieceFromCoordinates;
import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BreadFirstSearchTest {

    @Test
    void testBFSForMyInteger() {
        Node<MyInteger> myIntegerStart = new Node<>(new MyInteger(2));
        Node<MyInteger> myIntegerTarget = new Node<>(new MyInteger(1));
        AdjacentNodesFinder<MyInteger> myIntegerAdjacentNodesFinder = new MyIntegerAdjacentNodesFinder();
        Graph<MyInteger> integerGraph = new Graph<>(myIntegerAdjacentNodesFinder);
        Deque<Node<MyInteger>> deque = integerGraph.breadthFirstSearch(myIntegerStart, myIntegerTarget);

        log.info("Path: {}", deque.stream()
                .map(node -> node.getData().getInteger())
                .map(String::valueOf)
                .collect(joining(" -> ")));


        assertThat(deque.size()).isEqualTo(3);
    }

    @Test
    void testBFSForKnight() {
        Node<Piece> knightStart = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.START.x,
                Settings.START.y)));

        log.info("Starting Coordinates: {},{}",
                knightStart.getData().getCoordinates().x,
                knightStart.getData().getCoordinates().y);

        Node<Piece> knightTarget = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.TARGET.x,
                Settings.TARGET.y)));

        log.info("Target Coordinates: {},{}",
                knightTarget.getData().getCoordinates().x,
                knightTarget.getData().getCoordinates().y);

        AdjacentNodesFinder<Piece> knightAdjacentNodesFinder = new KnightAdjacentNodesFinder();
        Graph<Piece> knightGraph = new Graph<>(knightAdjacentNodesFinder);

        Deque<Node<Piece>> finalPath = knightGraph.breadthFirstSearch(knightStart, knightTarget);
        CoordinatesPathLogger.logPath(finalPath);

        Node<Piece> last = finalPath.peekLast();

        if (!finalPath.isEmpty()) {
            assertThat(last.getDepth()).isEqualTo(finalPath.size() - 1);
        }
    }

}
