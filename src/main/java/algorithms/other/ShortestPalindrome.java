package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/8/12.
 * 214. 最短回文串
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 相当于在原串中找最长的前缀回文串
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int n = s.length();
        s = s + "#" + new StringBuffer(s).reverse().toString();
        int k = next(s)[s.length() - 1];
        String r = s.substring(k + 1, n);
        String reverse = new StringBuffer(r).reverse().toString();
        return reverse + s.substring(0, n);
    }

    /**
     *  kmp 的next 方法
     * @param p
     * @return
     */
    private int[] next(String p){
        int[] next = new int[p.length()];
        Arrays.fill(next, -1);
        //i从1开始， 0 为 -1
        for(int i = 1, j = -1; i < p.length(); i++){
            while (j >= 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];//不匹配
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;//记录一下
        }
        return  next;
    }
}
