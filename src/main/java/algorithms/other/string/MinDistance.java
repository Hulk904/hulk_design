package algorithms.other.string;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/12/5.
 * 583. 两个字符串的删除操作
 *
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。


 */
public class MinDistance {

    /**
     * 编辑距离的简化版
     * 仍然动态规划解决。
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //别漏了初始化
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
