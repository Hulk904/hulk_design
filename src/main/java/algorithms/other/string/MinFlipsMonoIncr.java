package algorithms.other.string;

/**
 * Created by yangyuan on 2021/6/19.
 * 926. 将字符串翻转到单调递增
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。

 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。

 返回使 S 单调递增的最小翻转次数。

 */
public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String str) {
        int n = str.length();
        int [] s = new int[n + 1];
        for (int i = 1; i <= n; i++){
            s[i] = s[i - 1] + str.charAt(i - 1) - '0';
        }
        int res = n - s[n];
        for (int i = 1; i <= n; i++){
            //前面1的个数+后面0的个数  即需要修改的次数 遍历取个最小值
            res = Math.min(res, s[i] + n - i - (s[n] - s[i]));
        }
        return res;
    }
}
