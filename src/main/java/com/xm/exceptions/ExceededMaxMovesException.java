package com.xm.exceptions;

import lombok.Getter;

@Getter
public class ExceededMaxMovesException extends RuntimeException {

    private final int maxAllowedMoves;

    public ExceededMaxMovesException(String message, int maxAllowedMoves) {
        super(message);
        this.maxAllowedMoves = maxAllowedMoves;
    }

}
