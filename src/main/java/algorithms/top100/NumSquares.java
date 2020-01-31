package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/15.
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

 示例 1:

 输入: n = 12
 输出: 3
 解释: 12 = 4 + 4 + 4.

 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(4));

    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n ; i++){
            dp[i] = i;
            for (int j = 1; i - j*j >= 0; j++){ //注意这里是大于等于0
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
