package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/12/11.
 * 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。

 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：

  nums1[i] == nums2[j]
 且绘制的直线不与任何其他连线（非水平线）相交。
 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。

 以这种方法绘制线条，并返回可以绘制的最大连线数。

 */
public class MaxUncrossedLines {
    //  转换为最长公共子序列
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++){
            for (int j = 1; j <= B.length; j++){
                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
