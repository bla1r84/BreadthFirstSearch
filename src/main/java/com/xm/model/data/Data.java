package com.xm.model.data;

import java.util.Set;

/**
 * The nodes of the graph will be able to contain anything that implements this interface, be it chess pieces or
 * anything else
 */
public interface Data<T> {

    /**
     * Gets the current node (i.e. position) and returns the valid next moves. Implementation will vary depending on
     * the type of piece. In fact, the item in question might not even be a chess piece, but rather something else with
     * a different implementation, totally unrelated to chess.
     *
     * @return a Set of all the valid Nodes the item can move to
     */
    Set<T> getAdjacent();

}
