package com.xm.model.data;

import com.xm.model.Coordinates;
import com.xm.utils.ChessBoardDimensions;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece<Rook> {

    public Rook(Coordinates coordinates) {
        super(coordinates);
    }

    public static Rook createPieceFromCoordinates(Coordinates coordinates) {
        return new Rook(coordinates);
    }

    @Override
    public Set<Rook> getAdjacent() {
        Set<Rook> set = new HashSet<>();

        for (int i = this.getCoordinates().x + 1; i < ChessBoardDimensions.X; i++) {
            int y = this.getCoordinates().y;
            set.add(createPieceFromCoordinates(Coordinates.valueOf(i, y)));
        }

        for (int i = this.getCoordinates().y + 1; i < ChessBoardDimensions.Y; i++) {
            int x = this.getCoordinates().x;
            set.add(createPieceFromCoordinates(Coordinates.valueOf(x, i)));
        }

        return set;
    }

}
