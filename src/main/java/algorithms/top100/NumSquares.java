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

    /**
     * 数学方法
     *  一个数最多 四个数平方和表示
     *  。。。
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        if (check(n)) return 1;
        for (int a = 1; a <= n/a; a++){
            if (check(n - a*a)) return 2;
        }
        while (n%4 == 0) n/=4;
        if (n%8 != 7) return 3;
        return 4;
    }

    private boolean check (int x){
        int r = (int)Math.sqrt(x);
        return x == r*r;
    }
}
