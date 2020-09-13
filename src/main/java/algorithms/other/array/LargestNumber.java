package algorithms.other.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangyuan on 2020/8/8.
 * 179. 最大数
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

 */
public class LargestNumber {


    public String largestNumberSelf(int[] nums) {
        sort(nums, 0, nums.length - 1);
        if (nums[0] == 0)return "0";
        StringBuilder sb = new StringBuilder();
        for (int i : nums){
            sb.append(i);
        }
        return sb.toString();
    }

    void sort(int[] nums, int left ,int right){
        if (left >= right) return;
        int p = partition(nums, left, nums.length - 1);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    int partition (int[] nums, int left, int right){
        int p = nums[left];
        while (left < right){
            while (left < right && Long.parseLong(nums[right] + "" + p) <= Long.parseLong(p + "" + nums[right])){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && Long.parseLong(nums[left] + "" + p) >= Long.parseLong(p +"" + nums[left])){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = p;
        return left;
    }
}
