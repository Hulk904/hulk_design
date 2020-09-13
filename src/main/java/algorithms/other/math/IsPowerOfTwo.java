package algorithms.other.math;

/**
 * Created by yangyuan on 2020/8/22.
 * 231. 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n&(-n));//lowbit  求一个数的最后一位1
    }
}
