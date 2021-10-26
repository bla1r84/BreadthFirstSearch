package com.xm.services;

import com.xm.adjacentgetter.AdjacentNodesFinder;
import com.xm.exceptions.ExceededMaxMovesException;
import com.xm.exceptions.UnreachableTargetException;
import com.xm.model.data.Data;
import com.xm.model.Node;
import com.xm.utils.PathTraverser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static com.xm.utils.Settings.MAX_ALLOWED_MOVES;

/**
 * <p>
 * The Graph that uses breadth first search in order to find and return the path from the designated start to the
 * designated target. Breadth search first visits each node and finds its adjacent nodes based on some logic. For
 * example for chess pieces, the adjacent nodes are the squares that the piece can validly move to.
 *
 * <p>
 * The graph is fed the logic for finding the adjacent nodes through its constructor. The field adjacentNodesFinder
 * can be implemented in various ways and not necessarily only for chess pieces.
 *
 * @param <T> the type of Data the Nodes of the Graph contain
 */
@RequiredArgsConstructor
@Slf4j
public class Graph<T extends Data> {

    private final AdjacentNodesFinder<T> adjacentNodesFinder;

    public Deque<Node<T>> breadthFirstSearch(Node<T> start, Node<T> target) {
        Deque<Node<T>> deque = new ArrayDeque<>();
        Map<Node<T>, Node<T>> visited = new HashMap<>();

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
                return PathTraverser.traversePath(start, target, visited);
            }

            for (Node<T> n : adjacentNodesFinder.getAdjacent(current)) {
                deque.add(visited.computeIfAbsent(n, node -> Node.<T>builder()
                        .data(node.getData())
                        .previous(current)
                        .depth(current.getDepth() + 1)
                        .build()));
            }
        }

        throw new UnreachableTargetException("End position is unreachable!");
    }

}