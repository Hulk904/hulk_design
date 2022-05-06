package algorithms.other.string;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/10.
 * 821. 字符的最短距离
 *
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。

 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。

 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

 */
public class ShortestToChar {
    //两次遍历
    //j 记录最近的一个c
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        Arrays.fill(res, n + 1);
        //从左往右
        for (int i = 0, j = -1; i < n; i++){
            if (s.charAt(i) == c) j = i;
            if (j != -1) res[i] = i - j;
        }
        //从右往左
        for (int i = n - 1, j = -1; i >= 0; i--){
            if(s.charAt(i) == c) j = i;
            if (j != -1) res[i] = Math.min(res[i], j - i);
        }
        return res;
    }
}
