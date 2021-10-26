package com.xm.adjacentgetter;

import com.xm.exceptions.UnreachableTargetException;
import com.xm.model.data.MyInteger;
import com.xm.model.Node;

import java.util.Set;

public class MyIntegerAdjacentNodesFinder implements AdjacentNodesFinder<MyInteger> {

    /**
     * Just some random logic for finding the next possible integers to move to.
     *
     * @param current the current Node where the item is
     * @return a Set of all the valid Nodes the item can move to
     */
    @Override
    public Set<Node<MyInteger>> getAdjacent(Node<MyInteger> current) {
        switch (current.getData().getInteger()) {
            case 0:
                return Set.of(new Node<>(new MyInteger(1)), new Node<>(new MyInteger(2)));
            case 1:
                return Set.of(new Node<>(new MyInteger(2)));
            case 2:
                return Set.of(new Node<>(new MyInteger(0)), new Node<>(new MyInteger(3)));
            case 3:
                return Set.of(new Node<>(new MyInteger(3)));
            default:
                throw new UnreachableTargetException("unreachable");
        }
    }

}
