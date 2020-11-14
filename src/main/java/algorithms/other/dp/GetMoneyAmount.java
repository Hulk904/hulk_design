package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/9/26.
 * 375. 猜数字大小 II
 * 我们正在玩一个猜数游戏，游戏规则如下：
 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 */
public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++){
            for (int i = 1; i + len - 1 <= n; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                }
            }
        }
        return dp[1][n];
    }
}
