package algorithms.other.tanxin;

/**
 * Created by yangyuan on 2020/9/19.
 * 330. 按要求补齐数组
 *
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 
 * 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字
 * 都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需
 * 要补充的数字个数。

 */
public class MinPatches {

    /**
     贪心的难点是思路比较难想
     */
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int i = 0, res = 0;
        while ( x <= n){
            if (i < nums.length && nums[i] <= x) x += nums[i++];
            else {
                x += x;
                res++;
            }
        }
        return res;
    }
}
