package algorithms.top100;

/**
 * Created by yangyuan on 2020/4/6.
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

 返回获得利润的最大值。

 */
public class MaxProfit6 {
    public int maxProfit(int[] prices, int fee) {
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, dp_i0 - prices[i] - fee);
        }
        return dp_i0;
    }
}
