package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/9/20.
 * 357. 计算各个位数不同的数字个数
 *
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 */
public class CountNumbersWithUniqueDigits {

    /**
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] f = new int[n + 1];
        f[1] = 9;
        for (int i = 2; i <= n; i++){
            f[i] = f[i - 1]*(11- i);
        }
        int res = 1;
        for (int i = 1; i <= n; i++) res+=f[i];
        return res;
    }
}
