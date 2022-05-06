package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/3/7.
 * 689. 三个无重叠子数组的最大和
 *
 * 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。

 每个子数组的长度为k，我们要使这3*k个项的和最大化。

 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。

 */
public class MaxSumOfThreeSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 1; i<= n; i++) s[i] = s[i - 1] + nums[i - 1];
        int[][] dp = new int[n + 2][4];
        int x = n + 1, y = 3;
        for (int i = n - k + 1; i> 0; i--){
            for (int j = 1; j <= 3; j++){
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + k][j - 1] + s[i + k - 1] - s[i - 1]);
                if (dp[x][3] <= dp[i][3]) x = i;
            }
        }
        int[] res = new int[3];
        while (y > 0){
            while (dp[x][y] != dp[x + k][y - 1] + s[x + k - 1] - s[x - 1]) x++;
            res[3 - y] = x - 1;
            x += k;
            y--;
        }
        return res;
    }
}
