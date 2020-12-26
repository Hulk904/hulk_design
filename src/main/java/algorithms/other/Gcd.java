package algorithms.other;

/**
 * Created by yangyuan on 2020/4/26.
 * 最大公约数
 *
 * java没有直接求两个int 的 最大公约数方法
 * BigInteger 有个gcd成员方法，可以求一个BigInteger与另一个BigInteger的最大公约数
 */
public class Gcd {

    public static void main(String[] args) {
        System.out.println(gcd(-4,8));
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
