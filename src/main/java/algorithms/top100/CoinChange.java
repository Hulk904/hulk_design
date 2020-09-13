package algorithms.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/15.
 * 322
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 示例 1:

 输入: coins = [1, 2, 5], amount = 11
 输出: 3
 解释: 11 = 5 + 5 + 1

 */
public class CoinChange {

    public static void main(String[] args) {
        int[] data = {2};
        System.out.println(coinChange(data, 3));
    }


    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0 ) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }

        }
        return dp[amount] == amount + 1? -1 : dp[amount];
    }


}
