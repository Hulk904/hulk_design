package algorithms.other;

/**
 * Created by yangyuan on 2020/11/7.
 * 479. 最大回文数乘积
 * 你需要找到由两个 n 位数的乘积组成的最大回文数。

 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果
 */
public class LargestPalindrome {

    public static void main(String[] args) {
        LargestPalindrome l = new LargestPalindrome();
        System.out.println(l.largestPalindrome(5));
    }

    /**
     * 一种暴力实现
     * 这里是从结果开始倒着枚举的方式
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int)Math.pow(10, n);
        for (int i = max; i> 0; i--){
            String a = i + "";
            String b = new StringBuilder(a).reverse().toString();
            long num = Long.parseLong(a + b);
            for (long j = max; j*j >= num; j--){
                if (num%j == 0){
                    return (int)(num%1337);
                }
            }
        }
        return 0;
    }
}
