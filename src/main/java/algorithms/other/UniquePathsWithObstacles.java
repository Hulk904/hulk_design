package algorithms.other;

/**
 * Created by yangyuan on 2020/2/26.
 *63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

 网格中的障碍物和空位置分别用 1 和 0 来表示。

 说明：m 和 n 的值均不超过 100。

 *
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] data = {{0,1}};
        System.out.println(uniquePathsWithObstacles(data));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0){
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        int[] a = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] != 1) {
                    if (i == 0 && j == 0){
                        dp[0] = 1;
                    } else {
                        dp[j] = (j == 0 ? 0 : dp[j - 1]) + (i == 0 ? 0 : a[j]);
                    }
                } else {
                    dp[j] = 0;
                }
            }
            a = dp;
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
