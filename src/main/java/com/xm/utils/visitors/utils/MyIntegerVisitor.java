package com.xm.utils.visitors.utils;

import com.xm.exceptions.UnreachableTargetException;
import com.xm.model.data.MyInteger;
import lombok.experimental.UtilityClass;

import java.util.Set;

@UtilityClass
public class MyIntegerVisitor {

    public Set<MyInteger> visit(MyInteger mi) {
        switch (mi.getInteger()) {
            case 0:
                return Set.of(new MyInteger(1), new MyInteger(2));
            case 1:
                return Set.of(new MyInteger(2));
            case 2:
                return Set.of(new MyInteger(0), new MyInteger(3));
            case 3:
                return Set.of(new MyInteger(3));
            default:
                throw new UnreachableTargetException("Unreachable!");
        }
    }

}