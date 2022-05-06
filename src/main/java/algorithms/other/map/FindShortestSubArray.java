package algorithms.other.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/3/13.
 * 697. 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap();//记录次数
        Map<Integer, Integer> minp = new HashMap();//记录第一次出现
        Map<Integer, Integer> maxp = new HashMap();//记录最后一次出现
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            int x = nums[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
            max = Math.max(map.get(x), max);
            if (minp.get(x) == null) minp.put(x, i);
            maxp.put(x, i);
        }
        int res = Integer.MAX_VALUE;
        for (int i:nums){
            if (map.get(i) == max){
                res = Math.min(res, maxp.get(i) - minp.get(i) + 1);
            }
        }
        int [] b = new int[3];

        return res;

    }
}
