package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for (int idx = 1; idx < grid[0].length; idx++) {
            grid[0][idx] = grid[0][idx] + grid[0][idx-1];
        }

        for (int idx = 1; idx < grid.length; idx++) {
            grid[idx][0] = grid[idx][0] + grid[idx-1][0];
        }

        for (int y = 1; y < grid.length; y++) {
            for (int x = 1; x < grid[0].length; x++) {
                grid[y][x] = grid[y][x] + Math.min(grid[y-1][x], grid[y][x-1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
