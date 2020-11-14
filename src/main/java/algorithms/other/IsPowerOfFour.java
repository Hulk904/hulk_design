package algorithms.other;

/**
 *
 * 342. 4的幂
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 */
public class IsPowerOfFour {

    /**
     * 满足三个条件 大于0 、 平方数（开方后相乘 是不是自己） 、 只包含因子2
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        int r = (int)Math.sqrt(num);
        if (r*r != num) return false;
        return (1<<30)%num == 0;
    }
}
