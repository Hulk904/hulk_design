package algorithms.other.dfs;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/20.
 * 720. 词典中最长的单词
 *
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

 若无答案，则返回空字符串。

 */
public class LongestWord {
    int[][] son = new int[30010][26];
    int idx = 0;
    int id[] = new int[30010];

    /**
     * trie 树 + dfs ß
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Arrays.fill(id, -1);
        for (int i = 0; i< words.length; i++) insert(words[i], i);
        int[] t = dfs(0, 0);
        if (t[1] != -1) return words[t[1]];
        return "";
    }

    void insert(String str, int k){
        int p = 0;
        for (char c:str.toCharArray()){
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        id[p] = k;
    }

    /**
     *
     * @param p  根节点
     * @param len 根节点到当前节点长度
     * @return  0 长度， 答案id
     */
    int[] dfs(int p, int len){
        int[] res = new int[]{len, id[p]};
        for (int i = 0; i < 26; i++){
            int j = son[p][i];
            if (j > 0 && id[j] != -1){
                int[] t = dfs(j, len + 1);
                if (res[0] < t[0]) res = t;
            }
        }
        return res;
    }
}
