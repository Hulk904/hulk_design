package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yangyuan on 2020/10/25.
 * 446. 等差数列划分 II - 子序列
 *
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 */
public class NumberOfArithmeticSlices2 {

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        Map<Long, Integer>[]  dp = new Map[n];
        for (int i = 0; i < n; i++){
            dp[i] = new HashMap();
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int k = 0; k < i; k++){
                long j = A[i] - A[k];
                res += dp[k].getOrDefault(j, 0);
                dp[i].put(j, dp[i].getOrDefault(j, 0) + dp[k].getOrDefault(j, 0) + 1);
            }
        }
        return res;
    }
}
