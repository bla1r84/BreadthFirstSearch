package com.xm.model.data;

import com.xm.utils.visitors.DataVisitor;
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

    @Override
    public Set<MyInteger> accept(DataVisitor dv) {
        return dv.visit(this);
    }

}