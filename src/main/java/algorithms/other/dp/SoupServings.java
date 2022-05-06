package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/5/6.
 * 808. 分汤
 *
 * 有 A 和 B 两种类型的汤。一开始每种类型的汤有 N 毫升。有四种分配操作：

 提供 100ml 的汤A 和 0ml 的汤B。
 提供 75ml 的汤A 和 25ml 的汤B。
 提供 50ml 的汤A 和 50ml 的汤B。
 提供 25ml 的汤A 和 75ml 的汤B。
 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为0.25的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。

 注意不存在先分配100 ml汤B的操作。

 需要返回的值： 汤A先分配完的概率 + 汤A和汤B同时分配完的概率 / 2。

 */
public class SoupServings {
    public double soupServings(int n) {
        n = (n+24)/25;
        if(n >= 500) return 1;//n比较大时， A大概率的会分配完成
        double[][] dp = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                if (i == 0 && j == 0) dp[i][j] = 0.5;
                else if (i > 0 && j == 0) dp[i][j] = 0;
                else if (i == 0 && j > 0) dp[i][j] = 1;
                else {
                    //状态递推
                    dp[i][j] = (dp[g(i - 4)][j] + dp[g(i - 3)][g(j - 1)] + dp[g(i - 2)][g(j - 2)] + dp[g(i - 1)][g(j - 3)])/4;
                }
            }
        }
        return dp[n][n];
    }
    int g(int x){
        return Math.max(0, x);
    }
}
