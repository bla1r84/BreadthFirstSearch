package com.xm.adjacentgetter;

import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.piece.Rook;
import com.xm.utils.ChessBoardDimensions;

import java.util.HashSet;
import java.util.Set;

public class RookAdjacentGetter implements AdjacentGetter<Rook> {

    @Override
    public Set<Node<Rook>> getAdjacent(Node<Rook> current) {
        Set<Node<Rook>> set = new HashSet<>();

        for (int i = current.getPiece().getCoordinates().x + 1; i < ChessBoardDimensions.X; i++) {
            int y = current.getPiece().getCoordinates().y;
            set.add(new Node<>(new Rook(Coordinates.valueOf(i, y))));
        }

        for (int i = current.getPiece().getCoordinates().y + 1; i < ChessBoardDimensions.Y; i++) {
            int x = current.getPiece().getCoordinates().x;
            set.add(new Node<>(new Rook(Coordinates.valueOf(x, i))));
        }

        return set;
    }

}
