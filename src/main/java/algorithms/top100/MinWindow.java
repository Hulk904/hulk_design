package algorithms.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yangyuan on 2020/1/3.
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

 示例：

 输入: S = "ADOBECODEBANC", T = "ABC"
 输出: "BANC"

 */
public class MinWindow {

    public static void main(String[] args) {

        String a = "bbaac";
        String b = "aba";
        System.out.println(minWindow(a,b));

    }


    /**
     *  超出时间限制。。。。
     * @param s
     * @param t
     * @return
     */
    private static String minWindow(String s, String t) {
        int left =0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        Map<Character, Integer> needs = new HashMap<>();
        for (char c:t.toCharArray()){
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windows = new HashMap<>();
        int match = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (needs.get(c) != null && needs.get(c) > 0){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (Objects.equals(windows.get(c), needs.get(c))){
                    match ++;
                }
            }
            right++;
            while (match == needs.size()){
                minLength = Math.min(minLength, right - left);
                if (minLength == right -left){
                    start = left;
                }
                char l = s.charAt(left);
                if (needs.get(l) != null && needs.get(l) > 0){
                    windows.put(l, windows.get(l) - 1);
                    if (windows.get(l) < needs.get(l)){
                        match--;
                    }
                }
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }


}

