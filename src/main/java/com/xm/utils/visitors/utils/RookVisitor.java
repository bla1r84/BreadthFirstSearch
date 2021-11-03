package com.xm.utils.visitors.utils;

import com.xm.model.Coordinates;
import com.xm.model.data.Rook;
import com.xm.utils.ChessBoardDimensions;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class RookVisitor {

    public Set<Rook> visit(Rook r) {
        Set<Rook> set = new HashSet<>();

        for (int i = r.getCoordinates().x + 1; i < ChessBoardDimensions.X; i++) {
            int y = r.getCoordinates().y;
            set.add(Rook.createPieceFromCoordinates(Coordinates.valueOf(i, y)));
        }

        for (int i = r.getCoordinates().y + 1; i < ChessBoardDimensions.Y; i++) {
            int x = r.getCoordinates().x;
            set.add(Rook.createPieceFromCoordinates(Coordinates.valueOf(x, i)));
        }

        return set;
    }

}