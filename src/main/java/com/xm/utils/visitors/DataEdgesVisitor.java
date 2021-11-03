package com.xm.utils.visitors;

import com.xm.exceptions.UnreachableTargetException;
import com.xm.model.Coordinates;
import com.xm.model.data.Knight;
import com.xm.model.data.MyInteger;
import com.xm.model.data.Piece;
import com.xm.model.data.Rook;
import com.xm.utils.ChessBoardDimensions;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class DataEdgesVisitor implements DataVisitor {

    @Override
    public Set<Knight> visitKnight(Knight k) {
        return getAllPossible(k).stream()
                .filter(this::isValid)
                .collect(toSet());
    }

    private Set<Knight> getAllPossible(Knight k) {
        return Set.of(
                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x + 2,
                        k.getCoordinates().y + 1)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x + 1,
                        k.getCoordinates().y + 2)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x - 1,
                        k.getCoordinates().y + 2)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x - 2,
                        k.getCoordinates().y + 1)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x - 2,
                        k.getCoordinates().y - 1)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x - 1,
                        k.getCoordinates().y - 2)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x + 1,
                        k.getCoordinates().y - 2)),

                Knight.createPieceFromCoordinates(Coordinates.valueOf(
                        k.getCoordinates().x + 2,
                        k.getCoordinates().y - 1))
        );
    }

    private boolean isValid(Piece<?> p) {
        return p.getCoordinates().x >= 0
                && p.getCoordinates().x < ChessBoardDimensions.X
                && p.getCoordinates().y >= 0
                && p.getCoordinates().y < ChessBoardDimensions.Y;
    }

    @Override
    public Set<Rook> visitRook(Rook r) {
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

    @Override
    public Set<MyInteger> visitMyInteger(MyInteger mi) {
        switch (mi.getInteger()) {
            case 0:
                return Set.of(new MyInteger(1), new MyInteger(2));
            case 1:
                return Set.of(new MyInteger(2));
            case 2:
                return Set.of(new MyInteger(0), new MyInteger(3));
            case 3:
                return Set.of(new MyInteger(3));
            default:
                throw new UnreachableTargetException("Unreachable!");
        }
    }

}