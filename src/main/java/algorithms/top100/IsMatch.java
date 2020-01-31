package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/27.
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

 '.' 匹配任意单个字符
 '*' 匹配零个或多个前面的那一个元素
 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

 说明:

 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 示例 1:

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。


 照着敲的，还需要再看
 */
public class IsMatch {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '*' && dp[0][i - 1]){
                dp[0][i  + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*'){
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        dp[i + 1][j + 1] = dp[i  + 1][j - 1];
                    }else {
                        dp[i+ 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i+ 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
