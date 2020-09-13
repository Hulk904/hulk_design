package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/7/11.
 *
 * 87. 扰乱字符串
 */
public class IsScramble {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        for(int i = 0; i < a1.length; i++){
            if (a1[i] != a2[i]) return false;
        }
        int n = s1.length();
        //左右两边都不能为空串，所以从1开始
        for (int i = 1; i <= n-1; i++){
            /*
            将字符分为长度为i 和 length - i 的两个字符
             一种情况是不翻转
             一种情况是翻转  然后递归的去判断
             */
            //不翻转
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) return true;
            //翻转
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n- i))) return true;
        }
        return false;
    }
}
