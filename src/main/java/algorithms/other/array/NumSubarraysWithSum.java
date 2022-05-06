package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/6/20.
 * 930. 和相同的二元子数组
 *
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并有多少个和为 goal 的 非空 子数组。

 子数组 是数组的一段连续部分。
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int res= 0;
        for (int i = 1, s = 0; i<= n; i++){
            s+= nums[i - 1];
            res += map.getOrDefault(s - goal, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return res;
    }
}
