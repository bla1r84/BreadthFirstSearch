package com.xm;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.function.UnaryOperator;

import static java.util.stream.Collectors.toUnmodifiableSet;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PositionValidator {

    private final ChessBoard chessBoard;

    public UnaryOperator<Set<CoordinatesPair>> getValidNextPositions() {
        return allPositions -> allPositions.stream()
                .filter(this::isValid)
                .collect(toUnmodifiableSet());
    }

    private boolean isValid(CoordinatesPair position) {
        return position.x > 0
                && position.x < chessBoard.getWidth()
                && position.y > 0
                && position.y < chessBoard.getHeight();
    }

    public static PositionValidator createValidatorForChessBoard(ChessBoard chessBoard) {
        return new PositionValidator(chessBoard);
    }

}
