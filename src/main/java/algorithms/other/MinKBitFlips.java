package algorithms.other;

/**
 * Created by yangyuan on 2021/11/14.
 * 995. K 连续位的最小翻转次数
 *
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。

 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。


 */
public class MinKBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];//前缀和， 记录当前元素被操作的次数
        for (int i = 1; i <= n; i++){
            int t = s[i - 1] - s[Math.max(i - k, 0)] & 1;//第i个位置被操作多少次 （只关心奇偶性 、两次操作会被抵消）
            nums[i - 1]^= t;
            if (nums[i - 1] == 0){// 操作一次
                if (i >= n - k + 2) return -1;//从i开始长度为k的区间 。 超出区间表示无解
                s[i]++;
            }
            s[i] += s[i - 1];
        }
        return s[n];//所有区间操作次数
    }
}
