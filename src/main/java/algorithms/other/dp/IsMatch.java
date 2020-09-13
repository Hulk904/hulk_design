package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/6/25.
 * 44. 通配符匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

 '?' 可以匹配任何单个字符。
 '*' 可以匹配任意字符串（包括空字符串）。
 两个字符串完全匹配才算匹配成功

 相比10 简单些
 */
public class IsMatch {

    /**
     *  分 p[j] 为 * 和 不为 * 两种情况考虑
     *  为*    f(i,j) = f(i, j-1) || f(i - 1,j)
     *  不为*  f(i,j) = s[i] == p[j] && f(i-1, j- 1)
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int n =s.length();
        int m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++){//f[0][j] 可能有值
            for (int j = 1; j <= m; j++){//j == 0 没意义
                if (p.charAt(j) == '*'){
                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
                } else {
                    if (i > 0) {
                        dp[i][j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
