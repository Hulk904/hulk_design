package algorithms.other;

/**
 * Created by yangyuan on 2020/2/26.
 *329. 矩阵中的最长递增路径
 * 中文名 滑雪
 *
 * 给定一个整数矩阵，找出最长递增路径的长度。

 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

 示例 1:

 输入: nums =
 [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 输出: 4
 解释: 最长递增路径为 [1, 2, 6, 9]。

 */
public class LongestIncreasingPath {

    public static void main(String[] args) {
        int[][] data = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(data));
    }

    /**
     * 存放当前节点的最大上升值  当前最大
     */
    int[][] dp ;

    int[][] direction = {{1, 0},{0, 1},{-1, 0},{0, -1}};


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int result = 0;
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                result = Math.max(result, dp(i, j, matrix));
            }
        }
        return result;
    }

    int dp(int x, int y, int[][] matrix){
        if (dp[x][y] != 0){
            return dp[x][y];
        }
        for (int i = 0; i< direction.length; i++){
            int a = x + direction[i][0];
            int b = y +  direction[i][1];
            if (a >= 0 &&  a < matrix.length && b >=0 && b < matrix[0].length
                    && matrix[x][y] > matrix[a][b]) {
                dp[x][y] = Math.max(dp[x][y], dp(a, b, matrix) + 1);
            }
            else {
                dp[x][y] = Math.max(dp[x][y], 1);
            }
        }
        return dp[x][y];
    }
}
