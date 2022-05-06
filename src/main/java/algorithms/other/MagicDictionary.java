package algorithms.other;

/**
 * Created by yangyuan on 2021/3/6.
 * 676. 实现一个魔法字典
 *
 *设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
 * 使得所形成的新单词存在于你构建的字典中。

 实现 MagicDictionary 类：

 MagicDictionary() 初始化对象
 void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够
 与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。


 */
public class MagicDictionary {

    //trie 树 + dfs

    /** Initialize your data structure here. */

    int son[][] ;
    int idx;//节点 索引
    boolean isEnd[];//是否有以这个点结尾的trie

    public MagicDictionary() {
        son = new int[10010][26];
        idx = 0;
        isEnd = new boolean[10010];
    }

    public void buildDict(String[] dictionary) {
        for (String s:dictionary){
            insert(s);
        }
    }

    void insert(String s){
        int p = 0;
        for (char c:s.toCharArray()){
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        isEnd[p] = true;// 注意了这里是 isEnd[p] 不是 isEnd[idx]
    }

    boolean dfs(String s, int p, int u, int c/*当前多少不同字符*/){
        if (isEnd[p] && u == s.length() && c == 1) return true;
        if (c > 1 || u == s.length()) return false;
        for (int i = 0; i < 26; i++){
            if (son[p][i] == 0) continue;
            if (dfs(s, son[p][i], u + 1, c + ((s.charAt(u) - 'a' == i) ? 0 : 1))){
                return true;
            }
        }
        return false;
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, 0 ,0 , 0);
    }
}
