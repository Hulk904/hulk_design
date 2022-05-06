package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/3/27.
 * 741. 摘樱桃
 *
 * 一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：

 0 表示这个格子是空的，所以你可以穿过它。
 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 -1 表示这个格子里有荆棘，挡着你的路。
 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：

 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。

 */
public class CherryPickup {
    int N = 55;
    int dp[][][] = new int[N][N][N*2];
    //经典dp
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                Arrays.fill(dp[i][j], -10000);
            }
        }
        if (grid[0][0] != -1) dp[1][1][2] = grid[0][0];
        for (int k = 3; k <= n*2; k++){//k = i + j
            for (int i = Math.max(1, k - n); i <= Math.min(n, k - 1); i++){
                for (int j = Math.max(1, k - n); j <= Math.min(n, k - 1); j++){
                    if (grid[i - 1][k - i - 1] == -1 || grid[j - 1][k - j - 1] == -1) continue;//不能走
                    int t = grid[i - 1][k - i - 1];
                    if (i != j) t += grid[j - 1][k - j - 1];//只能采一次
                    //枚举四种情况 。 左左， 左下，下左，下下
                    for (int a = i - 1; a <= i; a++){
                        for (int b = j - 1; b <= j; b++){
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[a][b][k - 1] + t);
                        }
                    }
                }
            }
        }
        return Math.max(0, dp[n][n][n*2]);
    }
}
