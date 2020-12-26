package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/15.
 * 516. 最长回文子序列
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 */
public class LongestPalindromeSubseq {
    //区间dp ，求值模式类似，先枚举长度，后枚举左端点

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++){//注意 len <= n 这个等号
            for (int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if (len == 1) dp[i][j] = 1;
                else {
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i+ 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][n - 1];
    }
}
