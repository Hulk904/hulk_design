package algorithms.other;

/**
 * Created by yangyuan on 2021/11/20.
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        //双指针
        int res = 0;
        for (int i = 0, j = 0, cnt = 0; i < nums.length; i++){
            //cnt 表示 j, i 之间 0 的个数
            if (nums[i] == 0) cnt++;
            while (cnt > k){
                if (nums[j] == 0) cnt--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
