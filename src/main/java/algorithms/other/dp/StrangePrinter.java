package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/2/28.
 *
 * 664. 奇怪的打印机
 *
 * 有台奇怪的打印机有以下两个特殊要求：

 打印机每次只能打印同一个字符序列。
 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。

 */
public class StrangePrinter {

    public int strangePrinter(String s) {
        // 区间dp
        int n =s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 1; len <= n; len++){
            for (int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                dp[i][j] = 1 + dp[i + 1][j];
                for (int k = i + 1; k <= j; k++){
                    if (s.charAt(k) == s.charAt(i)){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];

    }
}
