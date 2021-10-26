package com.xm.model;

import com.xm.adjacentgetter.AdjacentGetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public class MyInteger implements Data, AdjacentGetter<MyInteger> {

    private final Integer integer;

    @Override
    public Set<Node<MyInteger>> getAdjacent(Node<MyInteger> current) {
        return null;
    }
}
