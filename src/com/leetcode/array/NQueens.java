package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < n; idx++) {
            sb.append(".");
        }
        List<List<String>> result = new ArrayList<>();
        solveNQueens(result, new ArrayList<Integer>(), 0, n, sb);
        return result;
    }

    public void solveNQueens(List<List<String>> result, List<Integer> curr, int lvl, int n, StringBuilder sb) {
        if (lvl == n) {
            List<String> list = new ArrayList<>();
            for (int idx = 0; idx < n; idx++) {
                sb.setCharAt(curr.get(idx), 'Q');
                list.add(sb.toString());
                sb.setCharAt(curr.get(idx), '.');
            }
            result.add(list);
            return;
        }

        outerloop:
        for (int idx = 0; idx < n; idx++) {
            if (curr.contains(idx)) continue;
            for (int lv = 0; lv < curr.size(); lv++) {
                if (curr.get(lv) == idx-(lvl-lv) || curr.get(lv) == idx+(lvl-lv)) continue outerloop;
            }
            curr.add(idx);
            solveNQueens(result, curr, lvl+1, n, sb);
            curr.remove(curr.size()-1);
        }
    }
}
