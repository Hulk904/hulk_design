package algorithms.other.bit;

/**
 * Created by yangyuan on 2020/9/26.
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class GetSum {

    /**
     * 异或运算 也叫 不进位的加法  然后 在加上 进位（& 操作）
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        //每次操作 a 二进制后面都会多个0，所以是最后会变为0
        if (a == 0) return b;
        int sum  = a^b, carry = (a&b)<<1;
        return getSum(carry, sum);
    }
}
