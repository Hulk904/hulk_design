package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/6/7.
 *1464. 数组中两元素的最大乘积
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

  请你计算并返回该式的最大值。

 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {-4, -3, 1, 2};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        //可以直接返回nums[size - 2] - 1)*(nums[size - 1] - 1 ，因为数据范围是1～1000
        return Math.max((nums[0] - 1)*(nums[1] - 1), (nums[size - 2] - 1)*(nums[size - 1] - 1));
    }

    //暴力  两层for 循环
}
