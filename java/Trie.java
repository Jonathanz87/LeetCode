/*
    problem 208
    Implement a trie with insert, search, and startsWith methods.
    Note:
    You may assume that all inputs are consist of lowercase letters a-z.
*/

public class Trie {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        trie.insert("abc");
        trie.insert("aaa");

        System.out.println(trie.search("abcd"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("aaa"));
        System.out.println(trie.search("abcasdgerfg"));
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.startsWith("abcd"));
        System.out.println(trie.startsWith("abcde"));
    }

    private final TrieNode ROOT = new TrieNode('\u0000');
    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] charArr = word.toCharArray();
        TrieNode node = ROOT;
        for(char c : word.toCharArray()){
            int childIndex = c - 'a';
            if(node.CHILDREN[childIndex] == null){
                node.CHILDREN[childIndex] = new TrieNode(c);
            }
            node = node.CHILDREN[childIndex];
        }
        node.isTerminal = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = ROOT;       

        for(char c : word.toCharArray()){
            int childIndex = c - 'a';
            if(node.CHILDREN[childIndex] == null){
                return false;
            }
            node = node.CHILDREN[childIndex];
        }

        return node.isTerminal;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = ROOT; 

        for(char c : prefix.toCharArray()){
            int childIndex = c - 'a';
            if(node.CHILDREN[childIndex] == null){
                return false;
            }
            node = node.CHILDREN[childIndex];
        }

        return true;
    }

    private static class TrieNode {
        final TrieNode[] CHILDREN = new TrieNode[26];
        final char VALUE;
        boolean isTerminal = false;

        TrieNode(char value) {
            this.VALUE = value;
        }
    }
}
