package algorithms.other;

/**
 * Created by yangyuan on 2020/11/7.
 *
 * 474. 一和零
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

 */
public class FindMaxForm {

    //二维背包
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s:strs){
            int a = 0, b = 0;
            for (char c:s.toCharArray()){
                if (c == '0') a++;
                else b++;
            }
            for (int i = m; i >= a; i--){
                for (int j = n; j >= b; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - a][j - b] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
