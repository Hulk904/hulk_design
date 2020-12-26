package algorithms.other.array;

/**
 * Created by yangyuan on 2020/12/20.
 * 629. K个逆序对数组
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。

 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。

 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。

 */
public class KInversePairs {

    public int kInversePairs(int n, int k) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n + 1][k + 1];// i 个元素， k 个逆序对  数组个数
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++){
            long s = 0;
            for (int j = 0; j <= k; j++){
                s += dp[i - 1][j];
                if (j - i >= 0) s -= dp[i - 1][j - i];
                dp[i][j] = (int)(s%mod);
            }
        }
        return (dp[n][k] + mod)%mod;
    }
}
