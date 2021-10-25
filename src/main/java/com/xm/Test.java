package com.xm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

@Slf4j
public class Test {

    private static final ChessBoard chessboard = new ChessBoard(8, 8);
    private static final Deque<Square> q = new ArrayDeque<>();

    public static void main(String[] args) {
        int startX = NumberUtils.toInt(args[0]);
        int startY = NumberUtils.toInt(args[1]);
        int endX = NumberUtils.toInt(args[2]);
        int endY = NumberUtils.toInt(args[3]);

        Square start = new Square(startX, startY, 0);
        Square end = new Square(endX, endY, Integer.MAX_VALUE);

        chessboard.getSquares()[start.x][start.y] = new Square(start.x, start.y, 0);

        q.add(start);

        while (!q.isEmpty()) {
            Square square = q.poll();

            if (end.equals(square)) {
                Deque<Square> path = getShortestPath(start, end);

                log.info("Minimum jumps required: {}", square.getDepth());
                log.info("Actual Path");
                log.info("(" + square.x + " " + square.y + ")");
                path.forEach(position -> log.info("(" + position.x + " " + position.y + ")"));

                return;
            }

            square.setDepth(square.getDepth() + 1);

            breathFirstSearch(square, square.getDepth());

        }

        log.warn("End position is not reachable for the knight");
    }

    private static void breathFirstSearch(Square current, int depth) {
        PositionValidator positionValidator = PositionValidator.createValidatorForChessBoard(chessboard);

        var validNextPositions = Knight.getPossibleNextPositions()
                .andThen(positionValidator.getValidNextPositions())
                .apply(new CoordinatesPair(current.x, current.y));

        for (CoordinatesPair next : validNextPositions) {
            Square position = chessboard.getSquares()[next.x][next.y];
            if (position.getDepth() > depth) {
                chessboard.getSquares()[next.x][next.y] = new Square(current.x, current.y, depth);
                q.add(Square.getSquareFromCoordinatesPair(next.x, next.y, depth));
            }

        }
    }

    private static Deque<Square> getShortestPath(Square start, Square end) {
        Deque<Square> path = new ArrayDeque<>();

        Square current = chessboard.getSquares()[end.x][end.y];

        while (!current.equals(start)) {
            path.add(current);
            current = chessboard.getSquares()[current.x][current.y];
        }

        path.add(new Square(start.x, start.y, 0));
        return path;
    }

}

