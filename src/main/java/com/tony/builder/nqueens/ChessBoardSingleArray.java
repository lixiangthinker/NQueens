package com.tony.builder.nqueens;

public class ChessBoardSingleArray {
    private final int DIMENSION;
    private int[] position;
    private final int POSITION_NOT_SET = -1;

    public ChessBoardSingleArray(int dimension) {
        DIMENSION = dimension;
        position = new int[dimension];
        for (int i = 0; i < DIMENSION; i++) {
            position[i] = POSITION_NOT_SET;
        }
    }

    private int solutionCount = 0;
    public int getSolutionCount(int currentLayer) {
        if (currentLayer == DIMENSION) {
            solutionCount++;
        } else {
            for (int x = 0; x < DIMENSION; x++) {
                position[currentLayer] = x;
                if (isAvailable(currentLayer)) {
                    getSolutionCount(currentLayer + 1);
                }
            }
        }
        return solutionCount;
    }

    public int getSolutionCountIter() {
        position[0] = POSITION_NOT_SET;
        int currentLayer = 0;

        while (currentLayer >= 0) {
            position[currentLayer]++;
            // find a valid position in current layer
            while (position[currentLayer] < DIMENSION && !isAvailable(currentLayer)) {
                position[currentLayer]++;
            }
            // successfully find a position in current layer
            if (position[currentLayer] < DIMENSION) {
                if (currentLayer == DIMENSION - 1) {
                    // get a solution.
                    solutionCount++;
                } else {
                    // continue to check next layer.
                    currentLayer++;
                    position[currentLayer] = POSITION_NOT_SET;
                }
            } else {
                // failed to find a position in current layer
                // move to upper layer.
                currentLayer--;
            }
        }

        return solutionCount;
    }

    public boolean isAvailable(int y) {
        for (int i = 0; i < y; i++) {
            // delta y = delta x; not same column;
            if (Math.abs(y - i) == Math.abs(position[y] - position[i]) || position[y] == position[i]) {
                return false;
            }
        }
        return true;
    }

    public void printChessBoard() {
        for (int i = 0; i < position.length; i++) {
            System.out.print(position[i] + "\t");
        }
        System.out.println();
        System.out.println();

        int[][] chessBoardArrayTwoDimension = new int[DIMENSION][DIMENSION];
        for (int y = 0; y < DIMENSION; y++) {
            for (int x = 0; x < DIMENSION; x++) {
                chessBoardArrayTwoDimension[y][x] = 0;
            }
            if (position[y] != POSITION_NOT_SET) {
                chessBoardArrayTwoDimension[y][position[y]] = 1;
            }
        }

        for (int y = 0; y < DIMENSION; y++) {
            for (int x = 0; x < DIMENSION; x++) {
                System.out.print(chessBoardArrayTwoDimension[y][x] + "\t");
            }
            System.out.println();
        }
    }
}
