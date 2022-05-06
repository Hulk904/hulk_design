package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/3/7.
 * 688. “马”在棋盘上的概率

 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 

 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 

 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。

 */
public class KnightProbability {
    public double knightProbability(int N, int K, int r, int c) {
        double dp[][][] = new double[25][25][101];// 在 i,j  已经跳了 k 步 ，最后到K  还在里面的概率
        for (int i = 0 ;i < N; i++){
            for (int j = 0; j < N; j++){
                dp[i][j][K] = 1;
            }
        }
        int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int k = K - 1; k >= 0; k--){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    for (int u = 0; u < 8; u++){
                        int x = i + dx[u];
                        int y = j + dy[u];
                        if (x >= 0 && x < N && y >= 0 && y < N){
                            dp[i][j][k] += dp[x][y][k + 1]/8;
                        }
                    }
                }
            }
        }
        return dp[r][c][0];
    }
}
