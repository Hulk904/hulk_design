package algorithms.top100;




/**
 * Created by yangyuan on 2020/2/14.
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0;i < word.length(); i++){
            if (!cur.containsKey(word.charAt(i))){
                return false;
            }
            cur = cur.get(word.charAt(i));
        }
        return cur.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0;i < prefix.length(); i++){
            if (!cur.containsKey(prefix.charAt(i))){
                return false;
            }
            cur = cur.get(prefix.charAt(i));
        }
        return true;
    }
}

class TrieNode {

    private TrieNode[] nodes;//子节点

    private final int R =26;

    private boolean end;

    public TrieNode(){
        nodes = new TrieNode[R];
    }

    public boolean containsKey (char c){
        return nodes[c - 'a'] != null;
    }

    public TrieNode get (char c) {
        return nodes[c - 'a'];
    }

    public void put (char c, TrieNode trieNode){
        nodes[c - 'a'] = trieNode;
    }

    public void setEnd (boolean end){
        this.end = end;
    }

    public boolean isEnd(){
        return end;
    }
}























