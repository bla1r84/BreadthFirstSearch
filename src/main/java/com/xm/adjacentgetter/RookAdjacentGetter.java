package com.xm.adjacentgetter;

import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.piece.Piece;
import com.xm.utils.ChessBoardDimensions;

import java.util.HashSet;
import java.util.Set;

public class RookAdjacentGetter implements AdjacentGetter<Piece> {

    @Override
    public Set<Node<Piece>> getAdjacent(Node<Piece> current) {
        Set<Node<Piece>> set = new HashSet<>();

        for (int i = current.getData().getCoordinates().x + 1; i < ChessBoardDimensions.X; i++) {
            int y = current.getData().getCoordinates().y;
            set.add(new Node<>(new Piece(Coordinates.valueOf(i, y))));
        }

        for (int i = current.getData().getCoordinates().y + 1; i < ChessBoardDimensions.Y; i++) {
            int x = current.getData().getCoordinates().x;
            set.add(new Node<>(new Piece(Coordinates.valueOf(x, i))));
        }

        return set;
    }

}
