package algorithms.other.array;

/**
 * Created by yangyuan on 2020/8/12.
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。

 */
public class MinSubArrayLen {

    /**
     * 双指针
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum - nums[j] >= s) sum -= nums[j++];
            if (sum >= s) res = Math.min(res, i - j + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
