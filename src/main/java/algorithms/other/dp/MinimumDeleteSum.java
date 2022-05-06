package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/14.
 * 712. 两个字符串的最小ASCII删除和
 *
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 */
public class MinimumDeleteSum {
    /**
     * 跟 最长公共子序列差不多
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], 100000000);
        }
        dp[0][0] = 0;
        for (int i = 1; i< m; i++) dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        for (int i = 1; i< n; i++) dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        for (int i = 1 ;i < m ;i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));//去掉i 或 j
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + s1.charAt(i - 1) + s2.charAt(j - 1));// 同时去掉i和j
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]); //都不去  ，前提是i和j处的字符相同
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
