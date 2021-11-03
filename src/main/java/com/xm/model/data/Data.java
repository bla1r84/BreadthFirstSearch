package com.xm.model.data;

import com.xm.utils.visitors.DataVisitor;

import java.util.Set;

/**
 * The nodes of the graph will be able to contain anything that implements this interface, be it chess pieces or
 * anything else
 */
public interface Data<T> {

    /**
     * Evaluates all the Edges of the Vertex. Implementation will vary depending on the type of data. The item in
     * question doesn't necessarily have to be a chess piece, it can be anything else.
     *
     * @return a Set of all the Edges of the Vertex
     */
    Set<T> accept(DataVisitor dv);

}
