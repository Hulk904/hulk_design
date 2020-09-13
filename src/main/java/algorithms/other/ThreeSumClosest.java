package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/6/14.
 *
 * 16. 最接近的三数之和
 *
 *给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。

 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int [] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int resSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            for (int left = i + 1, right = nums.length - 1; left < right; left++){
                while (right - 1 > left && nums[left] + nums[right - 1] + nums[i] >= target) right--;
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < res){
                    res = Math.abs(sum - target);
                    resSum = sum;
                }
                if (right - 1 > left){
                    sum = nums[i] + nums[left] + nums[right - 1];
                    if (target - sum < res){
                        res = target -sum;
                        resSum = sum;
                    }
                }
            }
        }
        return resSum;
    }

}
