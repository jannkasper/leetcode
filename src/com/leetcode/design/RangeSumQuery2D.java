package com.leetcode.design;

// https://leetcode.com/problems/range-sum-query-2d-immutable/
public class RangeSumQuery2D {
    class NumMatrix {
        int result[][];
        public NumMatrix(int[][] matrix) {
            this.result = new int[matrix.length +1][matrix[0].length +1];
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[0].length; x++) {
                    result[y+1][x+1] = matrix[y][x] + result[y+1][x] + result[y][x+1] - result[y][x];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return result[row2+1][col2+1] + result[row1][col1] - result[row2+1][col1] - result[row1][col2+1];
        }
    }
}
