package algorithms.other;

/**
 * Created by yangyuan on 2020/8/12.208.
 * 实现 Trie (前缀树)
 * 感觉这个实现更加简洁
 */
public class Trie2 {
    Node root;

    /** Initialize your data structure here. */
    public Trie2() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = root;
        for (char c:word.toCharArray()){
            int u = c - 'a';
            if (p.son[u] == null){
                p.son[u] = new  Node();
            }
            p = p.son[u];
        }
        p.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = root;
        for (char c:word.toCharArray()){
            int u = c - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return p.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (char c:prefix.toCharArray()){
            int u = c - 'a';
            if (p.son[u] == null) return false;
            p = p.son[u];
        }
        return true;

    }

    class Node{
        boolean end;
        Node[] son;
        public Node(){
            end = false;
            son = new Node[26];
        }
    }
}


























