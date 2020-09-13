package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/8/2.
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

 如果小数部分为循环小数，则将循环的部分括在括号内。

 */
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        //x/y 可能有大于Integer.MAX_VALUE
        long x = numerator;
        long y = denominator;
        if (x%y == 0) return x/y + "";
        StringBuilder sb = new StringBuilder();
        if (x < 0 || y < 0) sb.append("-");
        x = Math.abs(x);
        y = Math.abs(y);
        sb.append(x/y).append(".");
        x%=y;
        Map<Long, Integer> hash = new HashMap<>();
        while (x > 0){
            hash.put(x, sb.length());
            x*=10;
            sb.append(x/y);
            x%=y;
            if(hash.get(x) != null && hash.get(x) > 0){
                return sb.toString().substring(0, hash.get(x)) + "(" + sb.toString().substring(hash.get(x)) + ")";
            }
        }
        return sb.toString();
    }
}
