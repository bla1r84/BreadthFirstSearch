package com.xm.model.data;

import com.xm.utils.visitors.DataVisitor;

import java.util.Set;

/**
 * The nodes of the graph will be able to contain anything that implements this interface, be it chess pieces or
 * anything else
 */
public interface Data<T> {

    /**
     * Evaluates all the Edges of the Vertex. The evaluation depends on passing in the DataEdgesVisitor.
     *
     * @return a Set of all the Edges of the Vertex
     */
    Set<T> accept(DataVisitor dv);

}