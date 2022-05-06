package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/20.
 * 719. 找出第 k 小的距离对
 *
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 */
public class SmallestDistancePair {

    /**
     * 二分 + 双指针
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 1000000;
        while (l < r){
            int mid = l + r >> 1;
            if (get(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    int get(int[] nums, int mid){
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++){
            while (nums[i] - nums[j] > mid) j++;
            res += i - j;
        }
        return res;
    }
}
