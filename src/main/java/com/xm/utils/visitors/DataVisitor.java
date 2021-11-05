package com.xm.utils.visitors;

import com.xm.model.data.Knight;
import com.xm.model.data.MyInteger;
import com.xm.model.data.Rook;

import java.util.Set;

public interface DataVisitor {

    Set<Knight> visit(Knight k);

    Set<Rook> visit(Rook r);

    Set<MyInteger> visit(MyInteger mi);

}