package algorithms.other;

/**
 * Created by yangyuan on 2020/2/27.
 * 526. 优美的排列
 *
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

 第 i 位的数字能被 i 整除
 i 能被第 i 位上的数字整除
 现在给定一个整数 N，请问可以构造多少个优美的排列？

 */
public class CountArrangement {

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
    }
    //状态压缩dp
    public static int countArrangement(int N) {
        int[] dp = new int[(1 << N )];
        dp[0] = 1;
        for (int i = 0; i < (1<<N); i++){
            int s = 1;
            for (int j = 0; j < N; j++) s += i>>j & 1;//计算i 有多少个1
            for (int j = 1; j <= N; j++){
                if (((i>>(j-1))&1) == 0 && (j%s == 0 || s%j == 0)){
                    dp[i|(1<<(j-1))] += dp[i];
                }
            }
        }
        return dp[(1<<N) - 1];
    }
}
