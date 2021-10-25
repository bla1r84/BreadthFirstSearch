package com.xm;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class ChessBoard {

    private final int width;
    private final int height;
    private final Square[][] squares;

    public ChessBoard(int width, int height) {
        if (width < 3 || height < 3) {
            throw new IllegalArgumentException("Illegal size for chessboard (must be greater than 2");
        }

        this.width = width;
        this.height = height;

        squares = new Square[width][height];
        for (int i = 0; i < width; i++) {
            Arrays.fill(squares[i], Square.getDefaultSquare());
        }
    }

}
