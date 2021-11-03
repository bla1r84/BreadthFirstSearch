package com.xm;

import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.Knight;
import com.xm.services.Graph;
import com.xm.utils.CoordinatesPathLogger;
import com.xm.utils.Settings;
import com.xm.utils.visitors.DataEdgesVisitor;
import com.xm.utils.visitors.DataVisitor;
import lombok.extern.slf4j.Slf4j;

import static com.xm.model.data.Knight.createPieceFromCoordinates;

@Slf4j
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Node<Knight> knightStart = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.START.x,
                Settings.START.y)));

        Node<Knight> knightTarget = new Node<>(createPieceFromCoordinates(Coordinates.valueOf(
                Settings.TARGET.x,
                Settings.TARGET.y)));

        DataVisitor dataVisitor = new DataEdgesVisitor();

        Graph<Knight> knightGraph = new Graph<>(dataVisitor);

        CoordinatesPathLogger.logPath(knightGraph.breadthFirstSearch(knightStart, knightTarget));
        long end = System.currentTimeMillis();
        log.info("Time taken for knight: {} ms ", end - start);
    }

}