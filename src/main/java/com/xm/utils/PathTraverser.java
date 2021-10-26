package com.xm.utils;

import com.xm.model.Node;
import com.xm.model.data.Data;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Utility class that traverses the visited nodes in order to find the path from start to target
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PathTraverser {

    /**
     * Uses that map of the visited nodes to return the path from start to finish as a Deque
     *
     * @param start   the starting node
     * @param target  the target node
     * @param visited the map of the visited nodes
     * @param <T>     the type of Data the Nodes contain
     * @return the path from start to finish as a Deque
     */
    public static <T extends Data> Deque<Node<T>> traversePath(
            Node<T> start,
            Node<T> target,
            Map<Node<T>, Node<T>> visited) {
        Deque<Node<T>> path = new ArrayDeque<>();
        Node<T> current = visited.get(target);

        while (!current.equals(start)) {
            path.push(current);
            current = current.getPrevious();
        }

        path.push(start);

        return path;
    }

}
