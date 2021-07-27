package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-morse-code-words/
public class UniqueMorseCodeWords {
    final String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....",
            "..",".---","-.-",".-..","--","-.","---",".--.",
            "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 0) return 0;
        Set<String> result = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                sb.append(morse[ch - 'a']);
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}
