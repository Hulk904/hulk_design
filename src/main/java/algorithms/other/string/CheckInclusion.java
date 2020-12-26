package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/29.
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class CheckInclusion {
    //https://leetcode-cn.com/problems/permutation-in-string/solution/hua-dong-chuang-kou-by-muyids-4/
    public boolean checkInclusion(String s1, String s2) {
        int[] c = new int[26];
        for (char t:s1.toCharArray()){
            c[t - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s2.length()){
            char cur = s2.charAt(r++);
            c[cur - 'a']--;
            while (l < s2.length() && c[cur - 'a'] < 0){
                c[s2.charAt(l++) - 'a']++;
            }
        }
        return false;
    }
}
