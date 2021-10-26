package com.xm;

import com.xm.adjacentgetter.AdjacentNodesFinder;
import com.xm.adjacentgetter.KnightAdjacentNodesFinder;
import com.xm.adjacentgetter.MyIntegerAdjacentNodesFinder;
import com.xm.model.Coordinates;
import com.xm.model.data.MyInteger;
import com.xm.model.Node;
import com.xm.model.data.Piece;
import com.xm.services.Graph;
import com.xm.utils.CoordinatesPathLogger;
import com.xm.utils.Settings;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static com.xm.model.data.Piece.createPieceFromCoordinates;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BreadFirstSearchTest {

    @Test
    void testBFSForMyInteger() {
        Node<MyInteger> myIntegerStart = new Node<>(new MyInteger(2));
        Node<MyInteger> myIntegerTarget = new Node<>(new MyInteger(1));
        AdjacentNodesFinder<MyInteger> myIntegerAdjacentNodesFinder = new MyIntegerAdjacentNodesFinder();
        Graph<MyInteger> integerGraph = new Graph<>(myIntegerAdjacentNodesFinder);
        Deque<MyInteger> deque = integerGraph.breadthFirstSearch(myIntegerStart, myIntegerTarget);
        log.info("{}", deque);
        assertThat(deque.size()).isEqualTo(3);
    }

    @Test
    void testBFSForKnight() {
        Node<Piece> knightStart = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.START.x,
                Settings.START.y)));

        Node<Piece> knightTarget = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.TARGET.x,
                Settings.TARGET.y)));

        AdjacentNodesFinder<Piece> knightAdjacentNodesFinder = new KnightAdjacentNodesFinder();
        Graph<Piece> knightGraph = new Graph<>(knightAdjacentNodesFinder);

        Deque<Piece> finalPath = knightGraph.breadthFirstSearch(knightStart, knightTarget);
        log.info("{}", finalPath.peekLast());
        CoordinatesPathLogger.logPath(finalPath);
    }

}
