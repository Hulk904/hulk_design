package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/12/12.
 * 1039. 多边形三角剖分的最低得分
 * 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。

 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有
 N-2 个三角形的值之和。

 返回多边形进行三角剖分后可以得到的最低分

 */
public class MinScoreTriangulation {
    //区间dp
    public int minScoreTriangulation(int[] w) {
        int n = w.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++){
            for (int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if (len == 3) dp[i][j] = w[i]*w[j]*w[i + 1];
                else {
                    dp[i][j] = (int)1e9;
                    for (int k = i + 1; k <= j - 1; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + w[i]*w[k]*w[j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
