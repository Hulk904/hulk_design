package algorithms.other.dp;

/**
 *
 * 935. 骑士拨号器
 * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。

 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。

 你能用这种方式拨出多少个不同的号码？

 因为答案可能很大，所以输出答案模 10^9 + 7。

 */
public class KnightDialer {

    public int knightDialer(int n) {
        //dp[i][j] 跳了i次最后位于j的方案数
        int[][] dp = new int [n][10];
        for (int i = 0; i < 10; i++) dp[0][i] = 1;
        int MOD = 1000000007;
        //tr 记录 可以跳 i（0～9） 的所有数字
        int[][] tr = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        for (int i = 1; i< n; i++){
            for (int j = 0; j < 10; j++){
                for (int k:tr[j]){
                    dp[i][j] = (dp[i][j] + dp[i - 1][k])%MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++){
            res = (res + dp[n - 1][i])%MOD;
        }
        return res;
    }
}
