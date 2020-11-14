package algorithms.other.string;

/**
 * Created by yangyuan on 2020/10/5.
 * 395. 至少有K个重复字符的最长子串
 *
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        if (k == 1) return s.length();
        return count(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int count(char[] c, int k, int left, int right){
        if (right - left + 1 < k) return 0;
        int [] s = new int[26];
        //统计 left 和right之间字符个数
        for (int i = left; i<= right; i++){
            s[c[i] - 'a']++;
        }
        while (right - left + 1 >= k && s[c[right] - 'a'] < k) right--;
        while (right - left + 1 >= k && s[c[left] - 'a'] < k) left++;
        if (right - left + 1 < k) return 0;
        for (int i = left; i <= right; i++){
            if (s[c[i] - 'a'] < k){
                return Math.max(count(c, k, left, i - 1), count(c, k, i + 1, right));
            }
        }
        return right - left + 1;
    }
}
