package algorithms.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2020/1/8.
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。

 要求算法的时间复杂度为 O(n)。

 示例:

 输入: [100, 4, 200, 1, 3, 2]
 输出: 4
 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int t : nums){
            set.add(t);
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i] - 1)){
                continue;
            }
            int cur = nums[i];
            int tempNum = 1;
            while (set.contains(++cur)){
                tempNum++;
            }
            maxLength = Math.max(maxLength, tempNum);
        }
        return maxLength;
    }
}
