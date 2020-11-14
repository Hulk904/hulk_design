package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/10/2.
 * 377. 组合总和 Ⅳ
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 */
public class CombinationSum4 {

    /**
     * 与之前 不同的是 顺序不同 也算组合个数
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        //dp[j] 表示总和为j的所有方案
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++){
            for (int v:nums){
                if (j >= v){
                    dp[j] += dp[j - v];
                }
            }
        }
        return dp[target];

    }
}
