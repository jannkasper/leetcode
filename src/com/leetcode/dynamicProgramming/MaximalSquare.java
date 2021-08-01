package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        char result = '0';

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (x > 0 && y > 0 && matrix[y][x] == '1'){
                    char min = matrix[y][x-1] < matrix[y-1][x] ? matrix[y][x-1] : matrix[y-1][x];
                    min = matrix[y-1][x-1] < min ? matrix[y-1][x-1] : min;
                    min += 1;
                    matrix[y][x] = min;
                }
                result = matrix[y][x] > result ? matrix[y][x] : result;
            }
        }

        return (int)(result - '0')*(int)(result - '0');
    }
}
