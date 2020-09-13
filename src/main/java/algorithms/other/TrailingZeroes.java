package algorithms.other;

/**
 * Created by yangyuan on 2020/8/8.
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class TrailingZeroes {

    /**
     * 计算零个数相当于统计2和5的个数。显然2的个数比5的个数多，所以只需要计算5 因子个数就行
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int t = 0;
        while (n > 0){
            t += n/5;
            n/=5;
        }
        return t;
    }
}
