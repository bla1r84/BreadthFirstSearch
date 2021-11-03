package com.xm.model.data;

import com.xm.model.Coordinates;
import com.xm.utils.visitors.DataVisitor;

import java.util.Set;

public class Knight extends Piece<Knight> {

    public Knight(Coordinates coordinates) {
        super(coordinates);
    }

    public static Knight createPieceFromCoordinates(Coordinates coordinates) {
        return new Knight(coordinates);
    }

    @Override
    public Set<Knight> accept(DataVisitor dv) {
        return dv.visitKnight(this);
    }

}
