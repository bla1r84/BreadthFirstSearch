package com.xm;

import com.xm.adjacentgetter.AdjacentNodesFinder;
import com.xm.adjacentgetter.KnightAdjacentNodesFinder;
import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.Piece;
import com.xm.services.Graph;
import com.xm.utils.CoordinatesPathLogger;
import com.xm.utils.Settings;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Node<Piece> knightStart = new Node<>(new Piece(Coordinates.valueOf(
                Settings.START.getLeft(),
                Settings.START.getRight())));

        Node<Piece> knightTarget = new Node<>(new Piece(Coordinates.valueOf(
                Settings.TARGET.getLeft(),
                Settings.TARGET.getRight())));

        AdjacentNodesFinder<Piece> knightAdjacentNodesFinder = new KnightAdjacentNodesFinder();
        Graph<Piece> knightGraph = new Graph<>(knightAdjacentNodesFinder);

        CoordinatesPathLogger.logPath(knightGraph.breadthFirstSearch(knightStart, knightTarget));
        long end = System.currentTimeMillis();
        log.info("Time taken for knight: {} ms ", end - start);
    }

}
