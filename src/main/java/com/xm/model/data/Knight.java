package com.xm.model.data;

import com.xm.model.Coordinates;
import com.xm.utils.ChessBoardDimensions;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Knight extends Piece<Knight> {

    public Knight(Coordinates coordinates) {
        super(coordinates);
    }

    public static Knight createPieceFromCoordinates(Coordinates coordinates) {
        return new Knight(coordinates);
    }

    @Override
    public Set<Knight> getAdjacent() {
        Set<Knight> allPossible = getAllPossible();

        return allPossible.stream()
                .filter(this::isValid)
                .collect(toSet());
    }

    private Set<Knight> getAllPossible() {
        return Set.of(
                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x + 2,
                        this.getCoordinates().y + 1)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x + 1,
                        this.getCoordinates().y + 2)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x - 1,
                        this.getCoordinates().y + 2)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x - 2,
                        this.getCoordinates().y + 1)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x - 2,
                        this.getCoordinates().y - 1)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x - 1,
                        this.getCoordinates().y - 2)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x + 1,
                        this.getCoordinates().y - 2)),

                createPieceFromCoordinates(Coordinates.valueOf(
                        this.getCoordinates().x + 2,
                        this.getCoordinates().y - 1))
        );
    }

    private boolean isValid(Knight knight) {
        return knight.getCoordinates().x >= 0
                && knight.getCoordinates().x < ChessBoardDimensions.X
                && knight.getCoordinates().y >= 0
                && knight.getCoordinates().y < ChessBoardDimensions.Y;
    }

}
