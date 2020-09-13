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
        // k是剩余可交易次数
        //最后一维 0 表示不持有（卖了）， 1表示持有（买了）
        // dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        //解释：今天我没有持有股票，有两种可能：
//        要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
//        要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
//
//        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
//        max(   选择 rest  ,           选择 buy         )
//
//        解释：今天我持有着股票，有两种可能：
//        要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
//        要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。


        //具像化 k = 2时
        // dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i - 1][2][1] + prices[i]);
        // dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i - 1][1][0] - prices[i]);
        // dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i - 1][1][1] + prices[i]);
        // dp[i][1][1] = Math.max(dp[i-1][1][1], 0 - prices[i]);
        //避免o(n)的空间复杂度 ，用局部变量替代，因为只跟前一个有关
        //具体怎么定义变量可以根据上面的等式得到    买入时k减1
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i10 = 0;
        for (int i = 0; i < prices.length; i++){
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11,-prices[i]);//dp_i00 = 0
        }
        return dp_i20;//两次交易，最后手里没有股票
    }

    /** 前后缀分解
     *  用于求两段的问题
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 2];
        //从前往后遍历 f记录最大利益（）
        for (int i = 1, min = Integer.MAX_VALUE; i<= n; i++){
            f[i] = Math.max(f[i - 1], prices[i -1] - min);
            min = Math.min(min, prices[i -1]);
        }
        int res = 0;
        for (int i = n, max = 0; i > 0; i--){
            res = Math.max(res, max - prices[i - 1] + f[i - 1]);
            max = Math.max(max, prices[i - 1]);
        }
        return res;
    }
}
