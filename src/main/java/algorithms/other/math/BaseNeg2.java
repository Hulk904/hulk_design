package algorithms.other.math;

/**
 * Created by yangyuan on 2021/11/27.
 * 1017. 负二进制转换
 *
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。

 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。

 */
public class BaseNeg2 {
    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int r = n&1;
            sb.append(r);
            n = (n - r)/-2;
        }
        return sb.reverse().toString();
    }
}
