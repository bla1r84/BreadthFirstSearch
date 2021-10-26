package com.xm.adjacentgetter;

import com.xm.model.Coordinates;
import com.xm.model.Node;
import com.xm.model.data.Piece;
import com.xm.utils.ChessBoardDimensions;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.xm.model.data.Piece.createPieceFromCoordinates;
import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class KnightAdjacentNodesFinder implements AdjacentNodesFinder<Piece> {

    @Override
    public Set<Node<Piece>> getAdjacent(Node<Piece> currentKnightNode) {
        Set<Node<Piece>> allPossible = getAllPossible(currentKnightNode);
        return allPossible.stream().filter(this::isValid).collect(toSet());
    }

    private Set<Node<Piece>> getAllPossible(Node<Piece> currentKnightNode) {
        return Set.of(
                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x + 2,
                        currentKnightNode.getData().getCoordinates().y + 1)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x + 1,
                        currentKnightNode.getData().getCoordinates().y + 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x - 1,
                        currentKnightNode.getData().getCoordinates().y + 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x - 2,
                        currentKnightNode.getData().getCoordinates().y + 1)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x - 2,
                        currentKnightNode.getData().getCoordinates().y - 1)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x - 1,
                        currentKnightNode.getData().getCoordinates().y - 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x + 1,
                        currentKnightNode.getData().getCoordinates().y - 2)),

                createKnightNodeFromCoordinates(Coordinates.valueOf(
                        currentKnightNode.getData().getCoordinates().x + 2,
                        currentKnightNode.getData().getCoordinates().y - 1))
        );
    }

    private Node<Piece> createKnightNodeFromCoordinates(Coordinates coordinates) {
        return new Node<>(createKnightWithCoordinates(coordinates));
    }

    private Piece createKnightWithCoordinates(Coordinates coordinates) {
        return createPieceFromCoordinates(coordinates);
    }

    private boolean isValid(Node<Piece> knightNode) {
        return knightNode.getData().getCoordinates().x >= 0
                && knightNode.getData().getCoordinates().x < ChessBoardDimensions.X
                && knightNode.getData().getCoordinates().y >= 0
                && knightNode.getData().getCoordinates().y < ChessBoardDimensions.Y;
    }

}
