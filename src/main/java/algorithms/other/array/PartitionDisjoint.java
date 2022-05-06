package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/6/14.
 * 915. 分割数组
 * 给定一个数组 A，将其划分为两个连续子数组 left 和 right， 使得：

 left 中的每个元素都小于或等于 right 中的每个元素。
 left 和 right 都是非空的。
 left 的长度要尽可能小。
 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。

 */
public class PartitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        //先预处理i～n-1的最小值, r
        //从前往后处理 0～i 的最大值， 小于等于r[i+1]
        int n = nums.length;
        int[] r = new int[n];
        Arrays.fill(r, nums[n - 1]);
        for (int i = n - 2; i >= 0; i--){
            r[i] = Math.min(nums[i], r[i + 1]);
        }
        for (int i = 0, l = Integer.MIN_VALUE; i + 1 < n; i++){
            l = Math.max(l, nums[i]);
            if (l <= r[i + 1]) return i + 1;
        }
        return -1;
    }
}
