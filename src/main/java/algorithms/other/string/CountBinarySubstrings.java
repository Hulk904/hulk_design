package algorithms.other.string;

/**
 * Created by yangyuan on 2021/3/13.
 * 696. 计数二进制子串
 *
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。

 重复出现的子串要计算它们出现的次数。

 */

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int res = 0, last = 0;
        for (int i = 0; i < s.length(); i++){
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            int cur = j - i;
            i = j - 1;
            res += Math.min(last, cur);
            last = cur;
        }
        return res;
    }
}
