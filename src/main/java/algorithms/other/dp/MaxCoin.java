package algorithms.other.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/26.
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

 求所能获得硬币的最大数量。

 说明:

 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 dp[i,j]  不太好循环，要保证计算每个dp[i,j]的时候依赖的每个状态已经计算好了
 可以枚举区间长度的方式
 */
public class MaxCoin {

    public static void main(String[] args) {
        int[] data = {3,1,5,8};
        System.out.println(maxCoins(data));

    }

    public static int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length  + 2);
        list.add(1);
        for (int i:nums){
            list.add(i);
        }
        list.add(1);
        int dp[][] = new int[list.size()][list.size()];
        for (int len = 2; len < list.size(); len++) {//枚举区间长度
                for (int i = 0; i < list.size() - len; i++) {//枚举起点

                int j = i + len;//终点
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + list.get(i) * list.get(k) * list.get(j));
                }
            }
        }
        return dp[0][list.size() - 1];
    }
}
