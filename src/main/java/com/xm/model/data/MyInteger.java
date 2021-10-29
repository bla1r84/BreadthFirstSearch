package com.xm.model.data;

import com.xm.exceptions.UnreachableTargetException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MyInteger implements Data<MyInteger> {

    private final Integer integer;

    /**
     * Just some random logic for finding the next possible integers to move to.
     *
     * @return a Set of all the Edges of Integer
     */
    @Override
    public Set<MyInteger> getAdjacent() {
        switch (this.getInteger()) {
            case 0:
                return Set.of(new MyInteger(1), new MyInteger(2));
            case 1:
                return Set.of(new MyInteger(2));
            case 2:
                return Set.of(new MyInteger(0), new MyInteger(3));
            case 3:
                return Set.of(new MyInteger(3));
            default:
                throw new UnreachableTargetException("unreachable");
        }
    }

}
