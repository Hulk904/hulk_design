package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/28.
 * 764. 最大加号标志
 *
 * 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。

 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。

 */
public class OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][][] dp = new int[N][N][4];//分别记录四个维度的值
        //原始数组只记录了 为 0的。
        //初始化数组
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                Arrays.fill(dp[i][j], 1);
            }
        }
        for (int[] i:mines){
            Arrays.fill(dp[i[0]][i[1]], 0);
        }
        for (int i = 1; i < N; i++){
            for (int j = 1; j < N; j++){
                if (dp[i][j][0] == 0) continue;//注意下标0
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        for (int i = N - 2; i >= 0; i--){
            for (int j = N - 2; j >= 0; j--){
                if (dp[i][j][2] == 0)continue;//注意下标2
                dp[i][j][2] = dp[i][j + 1][2] + 1;
                dp[i][j][3] = dp[i + 1][j][3] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                res =Math.max(res, Math.min(Math.min(dp[i][j][0], dp[i][j][1]), Math.min(dp[i][j][2], dp[i][j][3])));
            }
        }
        return res;
    }
}
