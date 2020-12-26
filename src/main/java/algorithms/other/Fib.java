package algorithms.other;

/**
 * Created by yangyuan on 2020/11/15.
 *
 * 509. 斐波那契数
 */
public class Fib {

    //递归
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int a = 0;
        return fib(N - 1) + fib(N - 2);
    }
    //迭代
    public int fib2(int n){
        int a = 0, b = 1;
        while (n-- > 0){
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
