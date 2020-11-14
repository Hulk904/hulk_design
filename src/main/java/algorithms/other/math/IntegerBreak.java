package algorithms.other.math;

/**
 * Created by yangyuan on 2020/9/20.
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 拆分尽可能多的3
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) return 1*(n - 1);
        int p = 1;
        while (n >= 5) {
            n-= 3;
            p*=3;
        }
        return p*n;
    }
}
