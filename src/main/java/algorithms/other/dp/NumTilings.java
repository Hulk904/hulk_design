package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/4/25.
 * 790. 多米诺和托米诺平铺
 *
 * 有两种形状的瓷砖：一种是 2x1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。

 XX  <- 多米诺

 XX  <- "L" 托米诺
 X
 给定 N 的值，有多少种方法可以平铺 2 x N 的面板？返回值 mod 10^9 + 7。

 （平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。）

 */
public class NumTilings {
    //状态压缩dp简化版
    public int numTilings(int N) {
        int mod = (int)1e9 + 7;
        //f(i,j) 铺完前i - 1列，且i列被占用的状态为j的方案数
        //每列有四个状态 00，01，10，11
        int[][] w = new int[][]{{1,1,1,1},{0,0,1,1},{0,1,0,1},{1,0,0,0}};//状态转移矩阵
        int[][] dp = new int[N + 1][4];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]*w[j][k])%mod;
                }
            }
        }
        return dp[N][0];//第N列没有元素被占用
    }
}
