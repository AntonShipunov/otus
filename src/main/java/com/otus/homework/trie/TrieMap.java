package com.otus.homework.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {

    private final TrieMapNode root;

    public TrieMap() {
        this.root = new TrieMapNode();
    }

    public void insert(String word) {
        TrieMapNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieMapNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieMapNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            else node = node.children.get(c);
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieMapNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            else node = node.children.get(c);
        }
        return true;
    }

    static class TrieMapNode {

        Map<Character, TrieMapNode> children;
        boolean isEnd;

        public TrieMapNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }
}
