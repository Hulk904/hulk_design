package algorithms.other.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/7/26.
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

 返回 s 所有可能的分割方案。
 */
public class Partition {

    boolean[][] dp;

    List<List<String>> res;

    Stack<String> path;

    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        res = new ArrayList<>();
        path = new Stack<>();
        //dp记录 i 到 j 是不是回文串
        //dp[i,j] = s[i] == s[j] && dp[i+ 1, j - 1] = true
        //这种拓扑依赖（计算外面的时候依赖里面的
        //先遍历j然后遍历i
        //预处理 减少后面计算时间
        for (int j = 0; j < n; j++){
            for (int i = 0; i <= j; i++){
                if (i == j) dp[i][j] = true;
                else if(s.charAt(i) == s.charAt(j)) {
                    if (i + 1 > j - 1 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }
                }
            }
        }
        dfs(s, 0);
        return res;
    }
    void dfs(String s, int u){
        if (u == s.length()) res.add(new ArrayList<>(path));
        else {
            for (int i = u; i < s.length(); i++){
                if (dp[u][i]){
                    path.push(s.substring(u, i + 1));
                    dfs(s, i + 1);
                    path.pop();
                }
            }
        }
    }
}
