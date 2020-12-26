package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/22.
 * 537. 复数乘法
 *
 * 给定两个表示复数的字符串。

 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 */
public class ComplexNumberMultiply {

    public String complexNumberMultiply(String a, String b) {
        int m = Integer.parseInt(a.substring(0, a.lastIndexOf("+")));
        int n = Integer.parseInt(a.substring(a.lastIndexOf("+") + 1, a.length() - 1));
        int p = Integer.parseInt(b.substring(0, b.lastIndexOf("+")));;
        int q = Integer.parseInt(b.substring(b.lastIndexOf("+") + 1, b.length() - 1));
        return (m*p - n*q) + "+" + (m*q + n*p) + "i";
    }
}
