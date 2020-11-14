package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/11/1.
 * 464. 我能赢吗
 *
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。

 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？

 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。

 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？

 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。

 */
public class CanIWin {
    int[] f;
    int m;
    int n;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.n = maxChoosableInteger;
        this.m = desiredTotal;
        if (n*(n  + 1)/2 < m) return false;
        f = new int[1<<n];
        Arrays.fill(f, -1);
        return dp(0) > 0;
    }
    int dp(int x){//当前状态x 时 必赢还是必败
        if (f[x] != -1) return f[x];//记忆化搜索 ，已计算过
        int sum = 0;
        for (int i = 0; i < n ;i++){//求当前和
            if ((x >> i & 1) > 0){
                sum += i + 1;
            }
        }
        for (int i = 0; i < n; i++){//枚举当前所有转移
            if ((x >> i & 1) > 0) continue;//已经用过
            if (sum + i + 1 >= m) {//必胜
                f[x] = 1;
                return 1;
            }
            if (dp(x + (1 << i)) <= 0){//对方必败
                f[x] = 1;
                return 1;
            }
        }
        f[x] = 0;
        return 0;
    }
}
