package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/9.
 *
 * 813. 最大平均值和的分组
 *
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。

 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。

 */
public class LargestSumOfAverages {

    public double largestSumOfAverages(int[] A, int K) {
        //dp[i, j] 表示将[1, i]分成j段的方案的集合
        int n = A.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n ;i ++) s[i] = s[i - 1] + A[i - 1];// 前缀和数组
        double[][] dp = new double[n + 1][K + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1000000);
        }
        dp[0][0] = 0;
        for (int i = 1; i<= n; i++){
            for (int j = 1; j <= K; j++){
                for (int k = 0; k< i; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + (s[i] - s[k])/(i - k + 0.0));
                }
            }
        }
        return dp[n][K];
    }
}
