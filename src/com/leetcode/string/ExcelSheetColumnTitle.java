package com.leetcode.string;

// https://leetcode.com/problems/excel-sheet-column-title/submissions/
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            char rest = (char)('A' + ((columnNumber-1) % 26));
            result.insert(0, rest);
            columnNumber = (columnNumber-1)/26;
        }
        return result.toString();
    }
}
