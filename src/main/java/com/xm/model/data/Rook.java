package com.xm.model.data;

import com.xm.model.Coordinates;
import com.xm.utils.visitors.DataVisitor;

import java.util.Set;

public class Rook extends Piece<Rook> {

    public Rook(Coordinates coordinates) {
        super(coordinates);
    }

    public static Rook createPieceFromCoordinates(Coordinates coordinates) {
        return new Rook(coordinates);
    }

    @Override
    public Set<Rook> accept(DataVisitor dv) {
        return dv.visit(this);
    }

}