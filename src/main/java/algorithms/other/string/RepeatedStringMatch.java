package algorithms.other.string;

/**
 * Created by yangyuan on 2021/3/7.
 * 686. 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。

 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。

 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) sb.append(a);
        sb.append(a);
        if ( sb.toString().contains(b)){
            return sb.length()/a.length();
        }
        return -1;
    }

    //正规做法还是kmp
}
