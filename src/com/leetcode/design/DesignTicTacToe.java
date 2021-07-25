package com.leetcode.design;

// https://leetcode.com/problems/design-tic-tac-toe/
public class DesignTicTacToe {
    class TicTacToe {
        boolean currentX;
        int[][] matrix;
        boolean isFinished;
        /** Initialize your data structure here.
         1 - X
         2 - O */
        public TicTacToe() {
            currentX = true;
            isFinished = false;
            matrix = new int[3][3];
        }

        public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
            if (isFinished) {
                throw new GameEndException();
            }
            if (matrix[row][col] != 0) {
                throw new AlreadyTakenException();
            }

            if (currentX) {
                matrix[row][col] = 1;
            } else {
                matrix[row][col] = 2;
            }

            currentX = !currentX;
            return setFinished(row, col);
        }

        private boolean setFinished(int row, int col) {
            if (matrix[row][0] == matrix[row][1] &&  matrix[row][1] == matrix[row][2] && matrix[row][0] != 0) {
                isFinished = true;
                return true;
            } else if (matrix[0][col] == matrix[1][col] &&  matrix[1][col] == matrix[2][col] && matrix[0][col] != 0) {
                isFinished = true;
                return true;
            } else if (matrix[0][0] == matrix [1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != 0) {
                isFinished = true;
                return true;
            } else if (matrix[0][2] == matrix [1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != 0) {
                isFinished = true;
                return true;
            }
            return false;
        }
    }

    static class AlreadyTakenException extends Exception {}
    static class GameEndException extends Exception {}
}
