package algorithms.top100;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/1/15.
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
