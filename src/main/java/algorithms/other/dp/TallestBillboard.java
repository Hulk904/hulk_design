package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/7/5.
 * 956. 最高的广告牌
 * 你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。

 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。

 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。

 */
public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        //dp[i][j] 从前i个棍子中选，左-右=j，左边的最大值
        int n = rods.length;
        int m = 0;
        for (int i:rods) m+=i;
        int[][] dp = new int[n + 1][2*m + 1];// 差值区间是【-m，m】
        for (int i = 0; i <= n; i++){
            Arrays.fill(dp[i], (int)-1e8);
        }
        dp[0][m] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= m*2; j++){
                int x = rods[i - 1];
                dp[i][j] = dp[i - 1][j];//不选i
                if (j - x >= 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + x);//放在左边
                if (j + x <= m*2) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + x]);//放在右边
            }
        }
        return dp[n][m];
    }
}
