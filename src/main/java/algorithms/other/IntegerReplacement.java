package algorithms.other;

/**
 * Created by yangyuan on 2020/10/6.
 * 397. 整数替换
 *
 * 给定一个正整数 n，你可以做如下操作：

 1. 如果 n 是偶数，则用 n / 2替换 n。
 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 n 变为 1 所需的最小替换次数是多少？

 */
public class IntegerReplacement {

    //递归
    //咋看时间复杂度很高，其实 很低    根号n级别。
    public int integerReplacement(int n) {
        return (int) f(n);
    }

    long f(long n){
        if (n == 1) return 0;
        if (n%2 == 0) return f(n/2) + 1;
        return Math.min(f(n + 1), f(n - 1)) + 1;
    }

    /**
     * 分析题目：

     偶数直接右移，只有一种选项
     奇数+1或者-1，有两种选项。
     2.1 显然，让每一步1的数目最少好处大，于是 0bxxx01 采用 -1； 0bxxx11 采用 +1；
     2.2 特殊情况 3，按上述原则+1后两次右移共需3次；减一后只需一次右移共2次，因此3采用-1操作

     * @param n
     * @return
     */
    public int integerReplacement2(int n) {
        long t = n;//可能爆int
        int count = 0;
        while ( t != 1){
            if ((t&1) == 0) t = t>> 1;
            else {
                if (t == 3 || (t&2) == 0){
                    t = t - 1;
                } else {
                    t = t + 1;
                }
            }
            count ++;
        }
        return count;
    }
}
