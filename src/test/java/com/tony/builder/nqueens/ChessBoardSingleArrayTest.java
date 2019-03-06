package com.tony.builder.nqueens;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardSingleArrayTest {
    @Test
    public void getSolutionCount() {
        long start = System.currentTimeMillis();
        ChessBoardSingleArray chessBoard = new ChessBoardSingleArray(8);
        int solutionCount = chessBoard.getSolutionCount(0);
        long stop = System.currentTimeMillis();
        System.out.println("solutionCount = " + solutionCount + " cost time = " + (stop - start) + "ms");
        assertEquals(92, solutionCount);

        start = System.currentTimeMillis();
        chessBoard = new ChessBoardSingleArray(14);
        solutionCount = chessBoard.getSolutionCount(0);
        stop = System.currentTimeMillis();
        System.out.println("solutionCount = " + solutionCount + " cost time = " + (stop - start) + "ms");
    }

    @Test
    public void getSolutionCountIter() {
        long start = System.currentTimeMillis();
        ChessBoardSingleArray chessBoard = new ChessBoardSingleArray(8);
        int solutionCount = chessBoard.getSolutionCountIter();
        long stop = System.currentTimeMillis();
        System.out.println("solutionCount = " + solutionCount + " cost time = " + (stop - start) + "ms");
        assertEquals(92, solutionCount);

        start = System.currentTimeMillis();
        chessBoard = new ChessBoardSingleArray(14);
        solutionCount = chessBoard.getSolutionCount(0);
        stop = System.currentTimeMillis();
        System.out.println("solutionCount = " + solutionCount + " cost time = " + (stop - start) + "ms");
    }
}