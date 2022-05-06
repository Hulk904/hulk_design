package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/7/10.
 * 962. 最大宽度坡
 *
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。

 找出 A 中的坡的最大宽度，如果不存在，返回 0 。



 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        //对于每一个形如 A[i] = v 的元素，我们将其索引 i 按照对应值 v 排序之后的顺序写下。例如， A[0] = 7, A[1] = 2, A[2] = 5, A[3] = 4，
        //我们应该这样顺序写下索引值 i=1, i=3, i=2, i=0。
        //然后，当我们写下一个索引 i 的时候，我们可以得到候选的宽度答案 i - min(indexes_previously_written)
        //（如果这个值是正数的话）。 我们可以用一个变量 m 记录已经写下的最小索引。

        int n = nums.length;
        Integer[] t = new Integer[n];
        for (int i = 0; i < n; i++){
            t[i] = i;
        }
        Arrays.sort(t, (i, j) -> ((Integer)nums[i]).compareTo(nums[j]));
        int res = 0, min = n;
        for (int i = 0; i < n; i++){
            res = Math.max(res, i - min);
            min = Math.min(min, t[i]);
        }
        return res;
    }
}
