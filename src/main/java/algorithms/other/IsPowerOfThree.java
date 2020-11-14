package algorithms.other;

/**
 * Created by yangyuan on 2020/9/13.
 * 326. 3的幂
 */
public class IsPowerOfThree {

    /**
     * 因为3是质数，所以3^19的除数只有3^0,3^1,3^2...3^19,因此
     * 我们只需将3^19除以n，若余数是0则意味着n是3的幂。   3^19是最大的3的幂次方整数
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}
