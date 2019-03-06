package com.tony.builder.nqueens;

public class ChessBoardTwoDArray {
    private final int DIMENSION;
    private Integer[][] chessBoard;

    public ChessBoardTwoDArray(int dimension) {
        DIMENSION = dimension;
        chessBoard = new Integer[DIMENSION][DIMENSION];
        for (int y = 0; y < DIMENSION; y++) {
            for (int x = 0; x < DIMENSION; x++) {
                chessBoard[y][x] = 0;
            }
        }
    }

    public ChessBoardTwoDArray(Integer[][] chessBoard, int dimension) {
        this.chessBoard = chessBoard;
        DIMENSION = dimension;
    }

    public void printChessBoard() {
        for (int y = 0; y < DIMENSION; y++) {
            for (int x = 0; x < DIMENSION; x++) {
                System.out.print(chessBoard[y][x] + "\t");
            }
            System.out.println();
        }
    }

    public boolean settleQueenDFS(int y) {
        if (y == DIMENSION) {
            return true;
        }

        for (int x = 0; x < DIMENSION; x++) {
            if (layChess(x, y)) {
                if (settleQueenDFS(y+1)) {
                    return true;
                } else {
                    chessBoard[y][x] = 0;
                }
            }
        }

        return false;
    }

    public boolean layChess(int x, int y) {
        if (isValidPosition(x, y)) {
            chessBoard[y][x] = 1;
            return true;
        }
        return false;
    }

    public boolean isValidPosition(int inputX, int inputY) {
        //current row, current column is empty
        for (int i = 0; i < DIMENSION; i++) {
            if (chessBoard[i][inputX] == 1) {
                return false;
            }
            if (chessBoard[inputY][i] == 1) {
                return false;
            }
        }

        // check diagonal
        for (int y = 0; y < DIMENSION; y++) {
            for (int x = 0; x < DIMENSION; x++) {
                // get a chess
                if (chessBoard[y][x] == 0) {
                    continue;
                }
                // check if chess is on diagonal line;
                // y = kx+b; k = 1, -1
                if (Math.abs(y - inputY) == Math.abs(x - inputX)) {
                    return false;
                }
            }
        }
        return true;
    }
}