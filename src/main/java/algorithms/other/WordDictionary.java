package algorithms.other;

/**
 * Created by yangyuan on 2020/8/12.
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * 设计一个支持以下两种操作的数据结构：

 void addWord(word)
 bool search(word)
 search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

 */
public class WordDictionary {
    Node root;

    class Node {
        boolean end;
        Node[] son;
        public Node(){
            end = false;
            son = new Node[26];
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node p = root;
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if (p.son[index] == null){
                p.son[index] = new Node();
            }
            p = p.son[index];
        }
        p.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Node p = root;
        return dfs(p, 0, word);
    }

    boolean dfs(Node p, int index, String word){
        if (index == word.length()){
            return p.end;
        }
        if (word.charAt(index) != '.'){
            if (p.son[word.charAt(index) - 'a'] == null){
                return false;
            }
            return dfs(p.son[word.charAt(index) - 'a'], index + 1, word);
        } else {
            //是 .  则
            for (Node n:p.son){
                if (n != null && dfs(n, index + 1, word)) return true;
            }
            return false;
        }
    }
}
