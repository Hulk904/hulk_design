package algorithms.other;

import java.util.*;

/**
 * Created by yangyuan on 2020/7/26.
 *140. 单词拆分 II

 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

 */
public class WordBreak2 {
    boolean[] dp;
    List<String> res;
    Set<String> set;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.n = s.length();
        dp = new boolean[n + 1];
        set = new HashSet<>(wordDict);
        dp[n] = true;
        res = new ArrayList();
        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (set.contains(s.substring(i, j+ 1)) && dp[j + 1]){
                    dp[i] = true;
                }
            }
        }
        dfs(s, 0, new Stack<String>());
        return res;
    }

    void dfs(String s, int index, Stack<String> path){
        if (index == n){
            res.add(String.join(" ", path));
        } else {
            for (int i = index; i < n; i++){
                if (set.contains(s.substring(index, i + 1)) && dp[i + 1]){
                    path.push(s.substring(index, i + 1) );
                    dfs(s, i + 1, path);
                    path.pop();
                }
            }
        }
    }
}
