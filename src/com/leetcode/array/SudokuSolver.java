package com.leetcode.array;

// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    public boolean solveSudoku(char[][] board, int position) {
        if (position == 81) {
            return true;
        }

        int x = position % 9;
        int y = position / 9;

        if (board[y][x] == '.') {
            for (int idx = 1; idx <= 9; idx++) {
                if (valid(board, y, x, (char)(idx +'0'))) {
                    board[y][x] = (char)(idx +'0');
                    if (solveSudoku(board, position+1)) return true;
                }
            }
            board[y][x] = '.';
        } else {
            if (solveSudoku(board, position+1)) return true;
        }
        return false;
    }

    public boolean valid(char[][] board, int y, int x, char val) {
        for (int idx = 0; idx < 9; idx++) {
            if (board[y][idx] == val) return false;
        }

        for (int idx = 0; idx < 9; idx++) {
            if (board[idx][x] == val) return false;
        }
        int startY = y - (y % 3);
        int startX = x - (x % 3);

        for (int idxy = startY; idxy < startY+3; idxy++) {
            for (int idxx = startX; idxx < startX+3; idxx++) {
                if (board[idxy][idxx] == val) return false;
            }
        }
        return true;
    }
}
