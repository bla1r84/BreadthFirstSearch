package com.xm;

import com.xm.adjacentgetter.AdjacentGetter;
import com.xm.adjacentgetter.KnightAdjacentGetter;
import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.piece.Piece;
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

        AdjacentGetter<Piece> knightAdjacentGetter = new KnightAdjacentGetter();
        Graph<Piece> knightGraph = new Graph<>(knightAdjacentGetter);

        CoordinatesPathLogger.logPath(knightGraph.bfs(knightStart, knightTarget));
        long end = System.currentTimeMillis();
        log.info("Time taken for knight: {} ms ", end - start);
    }

}
