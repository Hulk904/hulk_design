package algorithms.top100;

/**
 * Created by yangyuan on 2020/7/12.
 * 97. 交错字符串
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

 示例 1:

 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 输出: true

 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (s3.length() != m + n) return false;

        boolean[][] dp = new boolean[n + 1][m + 1];
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                if (i == 0 && j == 0) dp[i][j] = true;
                else {
                    if (i > 0 && s1.charAt(i) == s3.charAt(i + j)) dp[i][j] = dp[i - 1][j];
                    if (j > 0 && s2.charAt(j) == s3.charAt(i + j)) dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];

    }

}
