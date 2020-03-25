package algorithms.other;

/**
 * Created by yangyuan on 2020/2/27.
 * 132. 分割回文串 II
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

 返回符合要求的最少分割次数。

 思路：
 先动态规划计算出来所有 i，j 是不是回文串
 第二步 动态规划计算 dp[i] = min
 *
 */
public class MinCut {

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    public static int minCut(String s) {
        boolean[][] cir = new boolean[s.length()][s.length()];
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < s.length() - i + 1; j++) {
                int left = j;
                int right = j + i - 1;
                if (s.charAt(left) == s.charAt(right)) {
                    cir[left][right] = (left + 1 > right - 1) || cir[left + 1][right - 1];
                }
            }
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++){
            dp[i] = s.length();
            for (int j = 1; j <= i; j++){
                if (cir[j-1][i-1]){
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length()] - 1;
    }
}
