package algorithms.other.string;

/**
 * Created by yangyuan on 2021/12/25.
 * 1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。

 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    int gcd(int a, int b){
        return b > 0 ? gcd(b, a%b) : a;
    }
}
