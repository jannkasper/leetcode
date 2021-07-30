package com.leetcode.string;

import java.util.*;

// https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for(int idx = 10; idx <= s.length(); idx++) {
            String dna = s.substring(idx-10, idx);
            if (!seen.add(dna)) {
                repeated.add(dna);
            }
        }

        return new ArrayList(repeated);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();


        for(int idx = 10; idx <= s.length(); idx++) {
            String dna = s.substring(idx-10, idx);
            Integer dnaCount = map.getOrDefault(dna, 0) + 1;
            map.put(dna, dnaCount);
            if (dnaCount == 2) result.add(dna);
        }

        return result;
    }

}
