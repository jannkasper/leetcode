package com.leetcode.design;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {

        class TrieNode {
            private TrieNode[] node;
            private final int R = 26;
            private boolean isEnd;

            TrieNode () {
                node = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return node[ch-'a'] != null;
            }

            public TrieNode get(char ch) {
                return node[ch-'a'];
            }

            public TrieNode put(char ch, TrieNode trieNode) {
                node[ch-'a'] = trieNode;
                return node[ch-'a'];
            }

            public void setEnd() {
                isEnd = true;
            }
            public boolean isEnd() {
                return isEnd;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode tail = root;
            for (char ch : word.toCharArray()) {
                if (tail.containsKey(ch)) {
                    tail = tail.get(ch);
                } else {
                    tail.put(ch, new TrieNode());
                    tail = tail.get(ch);
                }
            }
            tail.setEnd();
        }

        public boolean search(String word) {
            return DFS(root, word, 0);
        }

        private boolean DFS (TrieNode tail, String word, int idx) {
            if (idx == word.length()) return tail.isEnd();

            char currentChar = word.charAt(idx);
            if (currentChar == '.') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if(tail.containsKey(ch)) {
                        if (DFS(tail.get(ch), word, idx + 1) == true) {
                            return true;
                        }
                    }
                }
            } else if(tail.containsKey(currentChar)) {
                return DFS(tail.get(currentChar), word, idx + 1);
            }

            return false;
        }
    }
}
