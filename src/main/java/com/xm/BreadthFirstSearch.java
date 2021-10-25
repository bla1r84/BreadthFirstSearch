package com.xm;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.xm.CoordinatesPair.createPairFromCoordinates;
import static com.xm.Square.createSquareFromCoordinates;

@RequiredArgsConstructor
@Builder
@Slf4j
public class BreadthFirstSearch {

    private final ChessBoard chessboard;
    private final ChessPiece chessPiece;
    private final PositionValidator positionValidator;

    private final Deque<Square> deque = new ArrayDeque<>();

    public Deque<Square> getPath() {
        chessboard.getSquares()[chessPiece.getStart().getX()][chessPiece.getStart().getY()] =
                createSquareFromCoordinates(chessPiece.getStart().getX(), chessPiece.getStart().getY(), 0);

        deque.add(chessPiece.getStart());

        while (!deque.isEmpty()) {
            Square currentSquare = deque.poll();

            if (chessPiece.getEnd().equals(currentSquare)) {
                return reconstructPath(chessPiece.getStart(), chessPiece.getEnd());
            }

            currentSquare.setDepth(currentSquare.getDepth() + 1);
            breathFirstSearch(currentSquare, currentSquare.getDepth());
        }

        throw new UnreachableSquareException("End position is not reachable for the knight");
    }

    private Deque<Square> reconstructPath(Square start, Square end) {
        Deque<Square> path = new ArrayDeque<>();

        Square current = chessboard.getSquares()[end.getX()][end.getY()];

        while (!current.equals(start)) {
            path.add(current);
            current = chessboard.getSquares()[current.getX()][current.getY()];
        }

        path.add(createSquareFromCoordinates(start.getX(), start.getY(), 0));
        path.push(end);
        return path;
    }

    private void breathFirstSearch(Square current, int depth) {
        var validNextPositions = chessPiece.getPossibleNextPositions()
                .andThen(positionValidator.getValidNextPositions())
                .apply(createPairFromCoordinates(current.getX(), current.getY()));

        for (CoordinatesPair next : validNextPositions) {
            var position = chessboard.getSquares()[next.x][next.y];
            if (position.getDepth() > depth) {
                chessboard.getSquares()[next.x][next.y] = createSquareFromCoordinates(
                        current.getX(),
                        current.getY(),
                        depth);

                deque.add(createSquareFromCoordinates(next.x, next.y, depth));
            }
        }
    }
}
