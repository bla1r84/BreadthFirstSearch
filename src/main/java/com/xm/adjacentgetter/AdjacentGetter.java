package com.xm.adjacentgetter;

import com.xm.model.Data;
import com.xm.model.Node;

import java.util.Set;

public interface AdjacentGetter<T extends Data> {

    /**
     * Gets the current node (i.e. position) and returns the valid next moves. Implementation will vary depending on
     * the type of piece. In fact, the item in question might not even be a chess piece, but rather something else with
     * a different implementation, totally unrelated to chess.
     *
     * @param current the current Node where the item is
     * @return a Set of all the valid Nodes the item can move to
     */
    Set<Node<T>> getAdjacent(Node<T> current);

}
