package algorithms.top100;

/**
 * Created by yangyuan on 2020/3/29.
 * 309. 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
 */
public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0,  dp_i_1 = Integer.MIN_VALUE;
        int dp_i2_0 = 0;//不持有  前天的
        for (int i = 0; i < prices.length; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i2_0 - prices[i]);
            dp_i2_0 = temp;  //这里不能直接写 dp_i_0（下次看来就是昨天的）, 因为dp_i2_0记录的是前天的
        }
        return dp_i_0;
    }
}
