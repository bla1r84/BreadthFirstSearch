package com.xm;

import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.Knight;
import com.xm.model.data.MyInteger;
import com.xm.services.Graph;
import com.xm.utils.CoordinatesPathLogger;
import com.xm.utils.Settings;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static com.xm.model.data.Knight.createPieceFromCoordinates;
import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BreadFirstSearchTest {

    @Test
    void testBFSForMyInteger() {
        Node<MyInteger> myIntegerStart = new Node<>(new MyInteger(2));
        Node<MyInteger> myIntegerTarget = new Node<>(new MyInteger(1));
        Graph<MyInteger> integerGraph = new Graph<>();
        Deque<Node<MyInteger>> deque = integerGraph.breadthFirstSearch(myIntegerStart, myIntegerTarget);

        log.info("Path: {}", deque.stream()
                .map(Node::getData)
                .map(String::valueOf)
                .collect(joining(" -> ")));


        assertThat(deque.size()).isEqualTo(3);
    }

    @Test
    void testBFSForKnight() {
        Knight knightStart = createPieceFromCoordinates(Coordinates.valueOf(Settings.START.x, Settings.START.y));

        log.info("Starting Coordinates: {},{}",
                knightStart.getCoordinates().x,
                knightStart.getCoordinates().y);

        Knight knightTarget = createPieceFromCoordinates(Coordinates.valueOf(Settings.TARGET.x, Settings.TARGET.y));

        log.info("Target Coordinates: {},{}",
                knightTarget.getCoordinates().x,
                knightTarget.getCoordinates().y);


        Graph<Knight> knightGraph = new Graph<>();

        Deque<Node<Knight>> finalPath = knightGraph.breadthFirstSearch(new Node<>(knightStart), new Node<>(knightTarget));
        CoordinatesPathLogger.logPath(finalPath);

        Node<Knight> last = finalPath.peekLast();

        if (!finalPath.isEmpty()) {
            assertThat(last.getDepth()).isEqualTo(finalPath.size() - 1);
        }
    }

}
