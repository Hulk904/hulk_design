package algorithms.top100;

/**
 * Created by yangyuan on 2020/3/29.
 * 188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 */
public class MaxProfit5 {


    public int maxProfit(int k, int[] prices) {
        if (k > prices.length/2){
            return maxProfit2(prices);
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++){
            for (int j = 1; j <= k; j++){
                if (i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }
    //不限次数
    private int maxProfit2(int[] prices){
        int res = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }



}
