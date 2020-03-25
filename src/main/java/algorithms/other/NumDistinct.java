package algorithms.other;

/**
 * Created by yangyuan on 2020/2/27.
 *
 * 115. 不同的子序列
 *
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

 */
public class NumDistinct {

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        //都加1 避免处理边界情况
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= t.length(); j++){
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)){//这里需要减去1 得到正确的下标
                    dp[i][j]+= dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
