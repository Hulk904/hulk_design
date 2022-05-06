package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/6/26.
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
 （即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。

 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                for (int k = Math.max(0, j - 1); k <= Math.min(n - 1, j + 1); k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + matrix[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}
