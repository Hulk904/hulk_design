package algorithms.other;

/**
 * Created by yangyuan on 2020/3/18.
 * 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

 你的目标是确切地知道 F 的值是多少。

 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 */
public class SuperEggDrop {


    /**
     * leetcode超时
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int res = N +1 ;
        for (int i = 1; i <= N; i++){
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        for (int k = 2; k <= K; k++){
            for (int n = 1; n <= N; n++){
                for (int t = 1; t <= n; t++){
                    dp[k][n] = Math.min(dp[k][n],Math.max(dp[k - 1][t - 1]/*摔碎了*/,
                            dp[k][n - t]/*没有摔碎*/) + 1);
                }
                res = Math.min(res, dp[k][n]);
            }
        }
        return dp[K][N];

    }

    public int superEggDrop2(int K, int N) {
        int[][] dp = new int[10010][110];
        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= K; j++){
                dp[i][j] = dp[i - 1][j - 1] + 1 + dp[i - 1][j];
                if (dp[i][K] >= N) return i;
            }
        }
        return -1;
    }

}
