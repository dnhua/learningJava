package solution.top100;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Implement a trie with insert, search, and startsWith methods.
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 */
public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root; //root节点，不保存数据
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null)
                p.children[i] = new TrieNode();
            p = p.children[i];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null)
                return false;
            p = p.children[i];
        }
        return p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null)
                return false;
            p = p.children[i];
        }
        return true;
    }

    static class TrieNode {
        // Initialize your data structure here.
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        public TrieNode() {
            isWord = false;
            for (int i=0; i<26; i++)
                children[i] = null;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("asdsa");
        boolean startsWith = trie.startsWith("as");
        System.out.println(startsWith);
    }

}


