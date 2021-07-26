package com.leetcode.string;

// https://leetcode.com/problems/detect-capital/
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }

        // case 1: All capital
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
            // case 2 and case 3
        } else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        // if pass one of the cases
        return true;


//         if (word.length() < 2) return true;
//         boolean isCapital = word.charAt(1) >= 65 && word.charAt(1) <= 90;
//         if (isCapital && (word.charAt(0) >= 65 && word.charAt(0) <= 90) == false) {
//                 return false;
//             }

//         for (int idx = 2; idx < word.length(); idx++) {
//             if ((word.charAt(idx) >= 65 && word.charAt(idx) <= 90) != isCapital) {
//                 return false;
//             }
//         }
//         return true;
    }
}
