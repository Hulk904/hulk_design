package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/5.
 * 801. 使序列递增的最小交换次数
 *
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。

 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。

 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。

 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。

 */
public class MinSwap {

    public int minSwap(int[] A, int[] B) {
        int MAX = (int)1e8;
        //f(i, 0) 第i 个位置没有交换，并且前i个元素递增的最小交换次数
        //f(i, 1) 第i个位置minSwap交换，并且前i个元素严格递增的最小交换次数
        int n = A.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], MAX);
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++){
            if (A[i - 1] < A[i] && B[i - 1] < B[i]){
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if(B[i - 1] < A[i] && A[i - 1] < B[i]){
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
