package com.tony.builder.nqueens;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardTwoDArrayTest {

    @Test
    public void testLayChess() {
        for (int y = 0 ; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                ChessBoardTwoDArray chessBoard = new ChessBoardTwoDArray(8);
                chessBoard.layChess(x, y);
                chessBoard.printChessBoard();
            }
        }
    }

    @Test
    public void testSettleQueens() {
        long start = System.currentTimeMillis();
        ChessBoardTwoDArray chessBoard = new ChessBoardTwoDArray(8);
        boolean result = chessBoard.settleQueenDFS(0);
        long stop = System.currentTimeMillis();
        System.out.println("cost time = " + (stop - start) + "ms");
        assertTrue(result);
        chessBoard.printChessBoard();
    }

    @Test
    public void isValidPosition() {
        Integer[][] chessBoard = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
        };
        ChessBoardTwoDArray board = new ChessBoardTwoDArray(chessBoard, 8);

        boolean result = board.isValidPosition(3,0);
        assertFalse(result);
        result = board.isValidPosition(0,0);
        assertTrue(result);
        result = board.isValidPosition(5,0);
        assertFalse(result);
    }
    @Test
    public void isValidPositionV2() {
        Integer[][] chessBoard = {
                {1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
        };
        ChessBoardTwoDArray board = new ChessBoardTwoDArray(chessBoard, 8);

        boolean result = board.isValidPosition(0,0);
        assertFalse(result);
        result = board.isValidPosition(0,1);
        assertFalse(result);
    }
}