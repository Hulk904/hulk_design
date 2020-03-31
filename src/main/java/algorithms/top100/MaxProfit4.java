package algorithms.top100;

/**
 * Created by yangyuan on 2020/3/29.
 * 123. 买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 */
public class MaxProfit4 {

    public int maxProfit(int[] prices) {
        //展开 k = 2 的状态转换
        // dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i - 1][2][1] + prices[i]);
        // dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i - 1][1][0] - prices[i]);
        // dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i - 1][1][1] + prices[i]);
        // dp[i][1][1] = Math.max(dp[i-1][1][1], 0 - prices[i]);
        //避免o(n)的空间复杂度 ，用局部变量替代，因为只跟前一个有关
        //具体怎么定义变量可以根据上面的等式得到
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i10 = 0;
        for (int i = 0; i < prices.length; i++){
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11,-prices[i]);
        }
        return dp_i20;
    }
}
