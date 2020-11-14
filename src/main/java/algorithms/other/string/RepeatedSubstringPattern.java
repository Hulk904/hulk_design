package algorithms.other.string;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/11/1.
 * 459. 重复的子字符串
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。


 */
public class RepeatedSubstringPattern {

    /**
     * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String sb = s + s;
        return sb.substring(1, sb.length() - 1).contains(s);
    }


    /**
     * kmp
     * n - next(n） - 1 为最小周期。
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {
        int [] next = next(s);
        int n = s.length();
        int t = n - next[n - 1] - 1;
        return t < n && n%t == 0;
    }

    int [] next (String p){
        int[] next = new int[p.length()];
        Arrays.fill(next, - 1);
        for(int i = 1, j = -1; i < p.length(); i++){
            while (j >= 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];//不匹配
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;//记录一下
        }
        return next;
    }
}
