package algorithms.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/6/14.
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组
  跟三数之和差不多，多层循环
 */
public class FourSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1, u = nums.length - 1; k < u; k++){
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (u - 1 > k && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target) u--;
                    if (nums[i] + nums[j] + nums[k] + nums[u] == target){
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        item.add(nums[u]);
                        res.add(item);
                    }
                }
            }
        }
        return res;
    }

}
