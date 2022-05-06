package algorithms.other.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/5/29.
 * 873. 最长的斐波那契子序列的长度
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> pos = new HashMap();
        for (int i = 0; i < n ;i ++) pos.put(arr[i], i);
        int[][] dp = new int[n][n];//dp[i][j]最后数是ai， 倒数第二个数是aj的， 最长的子序列
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                int x = arr[i] - arr[j];
                dp[i][j] = 2;
                if (x < arr[j] && pos.get(x) != null){
                    int k = pos.get(x);
                    dp[i][j] = Math.max(dp[i][j], dp[j][k] + 1);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        if (res < 3) return 0;
        return res;
    }
}
