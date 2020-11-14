package algorithms.other;

/**
 * Created by yangyuan on 2020/11/8.
 * 483. 最小好进制
 *
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。

 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制

 */
public class SmallestGoodBase {

    /**
     * todo 还不理解
     *
     * https://leetcode-cn.com/problems/smallest-good-base/solution/bi-mian-er-fen-cha-zhao-de-jian-dan-javajie-fa-by-/
     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {
        long N = Long.parseLong(n);
        for (int m = 59; m > 1; m--){
            long k = (long)Math.pow(N, 1.0/m);
            if (k <= 1) continue;
            long s = 0;
            for (int i = 0; i <= m; i++){
                s = s*k + 1;
            }
            if (s == N) return k+"";
        }
        return (N - 1) + "";
    }

}
