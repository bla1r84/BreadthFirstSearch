package com.xm;

import com.xm.adjacentgetter.AdjacentGetter;
import com.xm.adjacentgetter.KnightAdjacentGetter;
import com.xm.exceptions.ExceededMaxMovesException;
import com.xm.exceptions.UnreachableSquareException;
import com.xm.model.Coordinates;
import com.xm.model.Data;
import com.xm.model.Node;
import com.xm.model.piece.Knight;
import com.xm.utils.PathLogger;
import com.xm.utils.Settings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static com.xm.utils.Settings.MAX_ALLOWED_MOVES;

@RequiredArgsConstructor
@Slf4j
public class Graph<T extends Data> {

    private final AdjacentGetter<T> adjacentGetter;
    private final Map<Node<T>, Node<T>> visited = new HashMap<>();

    public Deque<T> bfs(Node<T> start, Node<T> target) {
        Deque<Node<T>> deque = new ArrayDeque<>();

        start.setDepth(0);
        visited.put(start, start);
        deque.add(start);

        while (!deque.isEmpty()) {
            Node<T> current = deque.poll();

            if (current.getDepth() > MAX_ALLOWED_MOVES) {
                throw new ExceededMaxMovesException(
                        "Max allowed moves exceeded: " + MAX_ALLOWED_MOVES,
                        MAX_ALLOWED_MOVES);
            }

            if (current.equals(target)) {
                return reconstructPath(start, target);
            }

            for (Node<T> n : adjacentGetter.getAdjacent(current)) {
                visited.computeIfAbsent(n, node -> {
                    node.setPrevious(current);
                    node.setDepth(current.getDepth() + 1);
                    deque.add(node);
                    return node;
                });
            }
        }

        throw new UnreachableSquareException("End position is unreachable!");
    }

    private Deque<T> reconstructPath(Node<T> start, Node<T> target) {
        Deque<T> path = new ArrayDeque<>();
        Node<T> current = visited.get(target);

        while (!current.equals(start)) {
            path.push(current.getPiece());
            current = current.getPrevious();
        }

        path.push(start.getPiece());

        return path;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Node<Knight> knightStart = new Node<>(new Knight(Coordinates.valueOf(
                Settings.START.getLeft(),
                Settings.START.getRight())));

        Node<Knight> knightTarget = new Node<>(new Knight(Coordinates.valueOf(
                Settings.TARGET.getLeft(),
                Settings.TARGET.getRight())));

        AdjacentGetter<Knight> knightAdjacentGetter = new KnightAdjacentGetter();
        Graph<Knight> knightGraph = new Graph<>(knightAdjacentGetter);

        PathLogger.logPath(knightGraph.bfs(knightStart, knightTarget));
        long end = System.currentTimeMillis();
        log.info("Time taken for knight: {} ms ", end - start);
    }

}