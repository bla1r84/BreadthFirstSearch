package com.xm.utils.visitors;

import com.xm.model.data.Knight;
import com.xm.model.data.MyInteger;
import com.xm.model.data.Rook;
import com.xm.utils.visitors.utils.KnightVisitor;
import com.xm.utils.visitors.utils.MyIntegerVisitor;
import com.xm.utils.visitors.utils.RookVisitor;

import java.util.Set;

public class DataEdgesVisitor implements DataVisitor {

    @Override
    public Set<Knight> visit(Knight k) {
        return KnightVisitor.visit(k);
    }

    @Override
    public Set<Rook> visit(Rook r) {
        return RookVisitor.visit(r);
    }

    @Override
    public Set<MyInteger> visit(MyInteger mi) {
        return MyIntegerVisitor.visit(mi);
    }

}