package algorithms.other.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/12/5.
 * 1027. 最长等差数列
 给定一个整数数组 A，返回 A 中最长等差子序列的长度。

 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 \并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。



 */
public class LongestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int res = 2;
        for (int i = 0; i < n; i++){
            for (int k = 0; k < i; k++){
                int j = nums[k] - nums[i];
                if (dp[i] == null) dp[i] = new HashMap();
                dp[i].put(j, Math.max(dp[i].getOrDefault(j, 0), 2));
                if (dp[k] != null && dp[k].getOrDefault(j, 0) > 0){
                    dp[i].put(j, Math.max(dp[i].getOrDefault(j, 2), dp[k].getOrDefault(j, 2) + 1));
                    res = Math.max(res, dp[i].getOrDefault(j, 2));
                }
            }
        }
        return res;
    }
}
