package com.otus.homework.trie;

public class TrieArray {

    private final TrieArrayNode root;

    public TrieArray() {
        this.root = new TrieArrayNode();
    }

    public void insert(String word) {
        TrieArrayNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieArrayNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieArrayNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieArrayNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) return false;
        }
        return true;
    }


    static class TrieArrayNode {

        TrieArrayNode[] children;
        boolean isEnd;

        public TrieArrayNode() {
            this.children = new TrieArrayNode[26];
            this.isEnd = false;
        }
    }
}
