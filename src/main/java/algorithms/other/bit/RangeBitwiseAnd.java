package algorithms.other.bit;

/**
 * Created by yangyuan on 2020/8/9.
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 */
public class RangeBitwiseAnd {

    /**
     * 因为 只要有一个0，那么无论有多少个 1都是 0
     * 关键找到最后一个不一样的位
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n){
            m = m >>1;
            n = n >>1;
            i++;
        }
        return m<<i;
    }
}
