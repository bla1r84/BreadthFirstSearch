package com.xm;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Deque;

import static com.xm.Square.createSquareFromCoordinates;

@Slf4j
public class ChessKnightAlgorithm {

    private static final ChessBoard chessboard = new ChessBoard(8, 8);

    public static void main(String[] args) {
        int startX = NumberUtils.toInt(args[0]);
        int startY = NumberUtils.toInt(args[1]);
        int endX = NumberUtils.toInt(args[2]);
        int endY = NumberUtils.toInt(args[3]);

        BreadthFirstSearch search = BreadthFirstSearch.builder()
                .chessboard(new ChessBoard(8, 8))
                .chessPiece(new Knight(createSquareFromCoordinates(startX, startY, 0), createSquareFromCoordinates(endX, endY, Integer.MAX_VALUE)))
                .positionValidator(PositionValidator.createValidatorForChessBoard(chessboard))
                .build();

        Deque<Square> path = search.getPath();
        PathLogger.logPath(path);
    }

}

