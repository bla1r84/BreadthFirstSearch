package com.xm.services;

import com.xm.exceptions.ExceededMaxMovesException;
import com.xm.exceptions.UnreachableTargetException;
import com.xm.model.Node;
import com.xm.model.data.Data;
import com.xm.utils.PathTraverser;
import com.xm.utils.visitors.DataVisitor;
import lombok.RequiredArgsConstructor;

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
 * The graph is fed the logic for finding the adjacent nodes through its constructor. The Visitor pattern has been used
 * to determine the way the edges (adjacent nodes) of the vertex will be found.
 *
 * @param <T> the type of Data the Nodes of the Graph contain
 */
@RequiredArgsConstructor
public class Graph<T extends Data<T>> {

    private final DataVisitor dataVisitor;

    public Deque<Node<T>> breadthFirstSearch(Node<T> start, Node<T> target) {
        Deque<Node<T>> deque = new ArrayDeque<>();
        Map<Node<T>, Node<T>> visited = new HashMap<>();

        start.setDepth(0);
        visited.put(start, start);
        deque.offer(start);

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

            for (Data<T> adj : current.getData().accept(dataVisitor)) {
                Node<T> nodeFromData = Node.<T>builder()
                        .data(adj)
                        .previous(current)
                        .depth(current.getDepth() + 1)
                        .build();

                visited.computeIfAbsent(nodeFromData, node -> {
                    deque.offer(node);
                    return node;
                });
            }

        }

        throw new UnreachableTargetException("End position is unreachable!");
    }

}