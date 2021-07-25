package com.leetcode.design;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class ImplementTrie {
    class Trie {
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
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
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

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode tail = root;
            for (char ch : word.toCharArray()) {
                if (tail.containsKey(ch)) {
                    tail = tail.get(ch);
                } else {
                    return false;
                }
            }
            return tail.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode tail = root;
            for (char ch : prefix.toCharArray()) {
                if (tail.containsKey(ch)) {
                    tail = tail.get(ch);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
