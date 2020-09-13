package algorithms.other;

/**
 * Created by yangyuan on 2020/6/13.
 * 8. 字符串转换整数 (atoi)
 *
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

 在任何情况下，若函数不能进行有效的转换时，请返回 0 。

 提示：(所以不能用long存放中间结果)

 本题中的空白字符只包括空格字符 ' ' 。
 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }

    public static int myAtoi(String str) {
        int k = 0;
        while ( k < str.length() && str.charAt(k) == ' ') k++;
        if (k == str.length()) return 0;
        int minus = 1;
        if (str.charAt(k) == '-') {
            minus = -1;
            k++;
        } else if (str.charAt(k) == '+') {
            k++;
        }
        int res = 0;
        while (k < str.length() && str.charAt(k) >= '0' && str.charAt(k) <= '9'){
            int x = str.charAt(k) - '0';
            if (minus > 0 && res > (Integer.MAX_VALUE - x)/10) {
                return Integer.MAX_VALUE;
            }

            if (minus < 0 && -res < (Integer.MIN_VALUE + x)/10) {
                return Integer.MIN_VALUE;
            }
            //这里需要特判下 如果最后结果为负最大值，这里用int计算时 是放不下的(但是leetcode并没有报错，
            // 214748363*10 + 8 超出范围后直接为 -2147483638，然后 -2147483638 * -1 = -2147483638 这一些巧合导致没有报错，
            // 最后还是写上下面的特判)
            if (-res*10 - x == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            res = res*10 + x;
            k++;
            if (res > Integer.MAX_VALUE) break;
        }
        res *= minus;
        return res;
    }
}
