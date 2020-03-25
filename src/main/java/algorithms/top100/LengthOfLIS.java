package algorithms.top100;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/1/14.
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。  不要求连续

 示例:

 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] data = {1,3,5,2,4,6,7};
        System.out.println(lengthOfLIS(data));
    }


    /**
     * 动态规划 + 二分查找
     * dp 存放的是上升的序列
     * @param nums
     * @return
     */
    public static  int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            int position =  Arrays.binarySearch(dp, 0, res, nums[i]);
            if (position < 0){
                position = -position -1;
                dp[position] = nums[i];
            }
            if (res == position){
                res++;
            }
        }
        return res;
    }

    /**
     * 动态规划
     * 计算 dp【i】时 ，它由之前的 j [0,i) 的所有元素 计算而来
     * @param nums
     * @return
     */
    public static  int lengthOfLISDynamic(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
