package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/12/19.
 * 628. 三个数的最大乘积
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 1、三个正数 最大的三个正数
        // 2、正 负 负 最大的正，最小的两个负
        // 3、正 正 负 只有三个数
        // 4、负 负 负  最大的三个数  跟第一个一样
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1]*nums[n - 2]*nums[n - 3]);//两种情况包含了所有的分类情况
    }
}
