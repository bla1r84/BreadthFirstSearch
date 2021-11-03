package com.xm;

import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.Knight;
import com.xm.model.data.MyInteger;
import com.xm.services.Graph;
import com.xm.utils.CoordinatesPathLogger;
import com.xm.utils.Settings;
import com.xm.utils.visitors.DataEdgesVisitor;
import com.xm.utils.visitors.DataVisitor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static com.xm.model.data.Knight.createPieceFromCoordinates;
import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BreadFirstSearchTest {

    private static DataVisitor dataVisitor;

    @BeforeAll
    static void setup() {
        dataVisitor = new DataEdgesVisitor();
    }

    @Test
    void testBFSForMyInteger() {
        Node<MyInteger> myIntegerStart = new Node<>(new MyInteger(2));
        Node<MyInteger> myIntegerTarget = new Node<>(new MyInteger(1));
        Graph<MyInteger> integerGraph = new Graph<>(dataVisitor);
        Deque<Node<MyInteger>> deque = integerGraph.breadthFirstSearch(myIntegerStart, myIntegerTarget);

        log.info("Path: {}", deque.stream()
                .map(Node::getData)
                .map(data -> ((MyInteger) data))
                .map(MyInteger::getInteger)
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


        Graph<Knight> knightGraph = new Graph<>(dataVisitor);

        Deque<Node<Knight>> finalPath = knightGraph.breadthFirstSearch(new Node<>(knightStart), new Node<>(knightTarget));
        CoordinatesPathLogger.logPath(finalPath);

        Node<Knight> last = finalPath.peekLast();

        if (!finalPath.isEmpty()) {
            assertThat(last.getDepth()).isEqualTo(finalPath.size() - 1);
        }
    }

}
