package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/12/18.
 * 1048. 最长字符串链
 *
 * 给出一个单词列表，其中每个单词都由小写英文字母组成。

 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。

 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。

 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。

 */
public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());//按长度排序
        int n = words.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (check2(words[j], words[i])){//word[i] 是不是word[j] 的前身
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //判断a是不是b的子序列   写法更加优雅 时间居然慢点
    private boolean check(String a, String b){
        if (a.length() + 1 != b.length()){
            return  false;
        }
        int i = 0;
        for (char c:b.toCharArray()){
            if (i < a.length() && a.charAt(i) == c){
                i++;
            }
        }
        return i == a.length();
    }

    //自己写的比较繁琐的一种实现
    private boolean check2(String a, String b){
        int i = 0, j = 0;
        if (a.length() + 1 != b.length()){
            return false;
        }
        while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)){
            i++;j++;
        }
        if (i == a.length()) return true;
        j++;
        while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)){
            i++; j++;
        }
        return i == a.length() && j == b.length();
    }
}
