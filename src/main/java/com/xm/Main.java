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

import static com.xm.model.data.Piece.createPieceFromCoordinates;

@Slf4j
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Node<Piece> knightStart = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.START.x,
                Settings.START.y)));

        Node<Piece> knightTarget = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.TARGET.x,
                Settings.TARGET.y)));

        AdjacentNodesFinder<Piece> knightAdjacentNodesFinder = new KnightAdjacentNodesFinder();
        Graph<Piece> knightGraph = new Graph<>(knightAdjacentNodesFinder);

        CoordinatesPathLogger.logPath(knightGraph.breadthFirstSearch(knightStart, knightTarget));
        long end = System.currentTimeMillis();
        log.info("Time taken for knight: {} ms ", end - start);
    }

}