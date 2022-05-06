package algorithms.other.math;

/**
 * Created by yangyuan on 2020/12/27.
 * 650. 只有两个键的键盘
 *
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：

 Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。

 */
public class MinSteps {

    /**
     * 相当于对n做因式分解
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n/i; i++){
            while (n % i == 0){//可能多个
                res += i;
                n /= i;
            }
        }
        if (n > 1) res += n;
        return res;
    }
}
