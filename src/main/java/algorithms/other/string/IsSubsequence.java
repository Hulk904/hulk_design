package algorithms.other.string;

/**
 * Created by yangyuan on 2020/10/5.
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

 */
public class IsSubsequence {

    /**
     * 双指针
     * 遍历t， 如果字符和s的相同，那么指向s的后移一位，最后看是不是到s的尾部了
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++){
            if (j < s.length() && s.charAt(j) == t.charAt(i)){
                j++;
            }
            if (j == s.length()){
                return true;
            }
        }
        return j >= s.length();
    }
}
