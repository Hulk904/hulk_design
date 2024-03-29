package algorithms.other.string;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/15.
 *
 * 828. 统计子串中的唯一字符
 *
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。

 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。

 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。

 由于答案可能非常大，请将结果 mod 10 ^ 9 + 7 后再返回。

 */
public class UniqueLetterString {
    public int uniqueLetterString(String s) {
        //换种思路，计算每个字符对结果的贡献
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] p = new int[26];
        Arrays.fill(p, -1);
        for (int i = 0; i < n; i++){
            l[i] = p[s.charAt(i) - 'A'];
            p[s.charAt(i) - 'A'] = i;
        }
        Arrays.fill(p, n);
        for (int i = n - 1; i >= 0; i--){
            r[i] = p[s.charAt(i) - 'A'];
            p[s.charAt(i) - 'A'] = i;
        }
        int res = 0, mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++){
            res = (res + (i - l[i])*(r[i] - i)%mod);
        }
        return res;
    }
}
