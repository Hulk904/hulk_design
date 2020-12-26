package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/11/22.
 * 532. 数组中的 k-diff 数对
 *
 * 给定一个整数数组和一个整数 k，你需要在数组里找到不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。

 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：

 0 <= i, j < nums.length
 i != j
 |nums[i] - nums[j]| == k
 注意，|val| 表示 val 的绝对值。

 */
public class FindPairs {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        //单调性， 双指针 （i 往后的时候j 也往后）
        for (int i = 0, j = 0; i < nums.length; i++){
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;//元素相同取最后一个
            while (j < i && nums[i] - nums[j] > k) j++;
            if (j != i && nums[i] - nums[j] == k) res++;
        }
        return res;
    }
}
