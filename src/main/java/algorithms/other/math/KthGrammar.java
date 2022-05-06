package algorithms.other.math;

/**
 * Created by yangyuan on 2021/4/5.
 * 779. 第K个语法符号
 *
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，
 * 1替换为10。

 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始
 */
public class KthGrammar {
    public int kthGrammar(int N, int K) {
        K--;
        int res = 0;
        while (K > 0) {
            res ^= K&1;
            K >>= 1;
        }
        return res;
    }
}
