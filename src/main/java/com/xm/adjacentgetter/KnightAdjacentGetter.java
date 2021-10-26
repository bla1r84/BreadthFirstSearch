package com.xm.adjacentgetter;

import com.xm.utils.ChessBoardDimensions;
import com.xm.model.Coordinates;
import com.xm.model.piece.Knight;
import com.xm.model.Node;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class KnightAdjacentGetter implements AdjacentGetter<Knight> {

    @Override
    public Set<Node<Knight>> getAdjacent(Node<Knight> currentKnightNode) {
        Set<Node<Knight>> allPossible = getAllPossible(currentKnightNode);
        return allPossible.stream().filter(this::isValid).collect(toSet());
    }

    private Set<Node<Knight>> getAllPossible(Node<Knight> currentKnightNode) {
        return Set.of(
                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x + 2,
                        currentKnightNode.getPiece().getCoordinates().y + 1)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x + 1,
                        currentKnightNode.getPiece().getCoordinates().y + 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x - 1,
                        currentKnightNode.getPiece().getCoordinates().y + 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x - 2,
                        currentKnightNode.getPiece().getCoordinates().y + 1)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x - 2,
                        currentKnightNode.getPiece().getCoordinates().y - 1)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x - 1,
                        currentKnightNode.getPiece().getCoordinates().y - 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x + 1,
                        currentKnightNode.getPiece().getCoordinates().y - 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getPiece().getCoordinates().x + 2,
                        currentKnightNode.getPiece().getCoordinates().y - 1))
        );
    }

    private Node<Knight> createKnightNodeFromCoordinates(Coordinates coordinates) {
        return new Node<>(createKnightWithCoordinates(coordinates));
    }

    private Knight createKnightWithCoordinates(Coordinates coordinates) {
        return new Knight(coordinates);
    }

    private boolean isValid(Node<Knight> knightNode) {
        return knightNode.getPiece().getCoordinates().x >= 0
                && knightNode.getPiece().getCoordinates().x < ChessBoardDimensions.X
                && knightNode.getPiece().getCoordinates().y >= 0
                && knightNode.getPiece().getCoordinates().y < ChessBoardDimensions.Y;
    }

}
