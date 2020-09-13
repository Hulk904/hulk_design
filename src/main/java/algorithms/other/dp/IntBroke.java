package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/4/3.
 * 900. 整数划分  acwing
 * 一个正整数n可以表示成若干个正整数之和，形如：n=n1+n2+…+nk，其中n1≥n2≥…≥nk,k≥1。

 我们将这样的一种表示称为正整数n的一种划分。

 现在给定一个正整数n，请你求出n共有多少种不同的划分方法。

 由于答案可能很大，输出结果请对109+7取模。

 计数类dp  可以类比  完全背包问题
 */
public class IntBroke {

    public static void main(String[] args) {
        System.out.println(intBroke(5));
    }


    private static int intBroke(int n){
        int[] dp = new int[n  + 1];
        int mod = (int)1e9 + 7;
        dp[0] = 1;
        for (int i = 1; i <= n; i++){//体积
            for (int j = i; j <= n; j ++){//容量
                dp[j] = (dp[j] + dp[j - i]) % mod;
            }
        }
        return dp[n];
    }
}
