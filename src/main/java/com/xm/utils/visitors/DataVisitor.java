package com.xm.utils.visitors;

import com.xm.model.data.Knight;
import com.xm.model.data.MyInteger;
import com.xm.model.data.Rook;

import java.util.Set;

public interface DataVisitor {

    Set<Knight> visitKnight(Knight k);

    Set<Rook> visitRook(Rook r);

    Set<MyInteger> visitMyInteger(MyInteger mi);

}