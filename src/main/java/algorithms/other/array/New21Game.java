package algorithms.other.array;

/**
 * Created by yangyuan on 2021/5/15.
 * 837. 新21点
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：

 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。

 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？

 */
public class New21Game {
    //概率论问题
    //dp 解决  反着推
    public double new21Game(int N, int K, int maxPts) {
        if (K == 0) return 1.0;
        double dp [] = new double[20010];
        for (int i = K; i <= N; i++) dp[i] = 1;
        for (int i = 1; i <= maxPts; i++){
            dp[K - 1] += dp[K - 1 + i]/maxPts;
        }
        for (int i = K - 2; i >= 0; i--){
            dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + maxPts + 1])/maxPts;
        }
        return dp[0];
    }
}
