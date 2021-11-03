package com.xm.utils.visitors.utils;

import com.xm.model.Coordinates;
import com.xm.model.data.Knight;
import com.xm.model.data.Piece;
import com.xm.utils.ChessBoardDimensions;
import lombok.experimental.UtilityClass;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@UtilityClass
public class KnightVisitor {

    public Set<Knight> visit(Knight k) {
        return getAllPossible(k).stream()
                .filter(KnightVisitor::isValid)
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

    private boolean isValid(Piece<Knight> p) {
        return p.getCoordinates().x >= 0
                && p.getCoordinates().x < ChessBoardDimensions.X
                && p.getCoordinates().y >= 0
                && p.getCoordinates().y < ChessBoardDimensions.Y;
    }

}