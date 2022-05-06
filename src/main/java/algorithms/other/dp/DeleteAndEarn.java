package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/3/27.
 * 740. 删除与获得点数
 *
 * 给定一个整数数组 nums ，你可以对它进行一些操作。

 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。

 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

 */
public class DeleteAndEarn {

    int N = 10010;
    int cnt [] = new int[N];
    int dp[][] = new int[N][2];
    public int deleteAndEarn(int[] nums) {
        for (int i:nums) cnt[i]++;
        int res = 0;
        for (int i = 1; i < N; i++){//遍历的是N，而不是数组nums。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); // 不选i
            dp[i][1] = dp[i - 1][0] + i * cnt[i]; //选i
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
