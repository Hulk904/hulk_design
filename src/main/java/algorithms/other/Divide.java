package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/6/20.
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

 返回被除数 dividend 除以除数 divisor 得到的商。

 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }

    /**
     * 虽然题目提示只能用int 范围。但是本事是会溢出的，比如 负的int最大值除以 -1 的结果就会溢出（大于int的正的最大值）
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        boolean isMinus = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) isMinus = true;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        List<Long> list = new ArrayList<>();
        for (long i = b; i <= a; i = i + i) list.add(i);
        long res = 0;
        for (int i = list.size() - 1; i >= 0; i--){
            if (a >= list.get(i)){
                a -= list.get(i);
                res += 1l << i;
            }
        }
        if (isMinus) res = -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}
