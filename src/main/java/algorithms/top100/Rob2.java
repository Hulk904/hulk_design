package algorithms.top100;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/1/9.
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

 */
public class Rob2 {

    public static void main(String[] args) {
        int[] data = {1,2,3,1};
        System.out.println(rob(data));
    }

    public static int rob(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob2(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob2(Arrays.copyOfRange(nums, 1 ,nums.length)));
    }

    public static int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]);
        boolean usedFirstElement = true;
        for (int i = 2; i < nums.length; i++){
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
        }
        return result[nums.length - 1];
    }
}
