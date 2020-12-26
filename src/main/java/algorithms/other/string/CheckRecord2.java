package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/28.
 * 552. 学生出勤记录 II

 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。

 学生出勤记录是只包含以下三个字符的字符串：

 'A' : Absent，缺勤
 'L' : Late，迟到
 'P' : Present，到场
 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。

 */
public class CheckRecord2 {

    /**
     * 可以看看leetcode 官网相关的解答。
     * 这里是ac题解
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        int dp[][][] = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        int M = 1000000007;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                for (int k = 0; k < 3; k++){
                    if (j == 0) dp[i + 1][j + 1][0] = (dp[i + 1][j + 1][0] + dp[i][j][k]) % M;//A 合法
                    if (k + 1 <= 2) dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + dp[i][j][k]) % M;//P合法
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][k]) % M;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < 2; j++){
            for (int k = 0; k < 3; k++){
                res = (res + dp[n][j][k]) % M;
            }
        }
        return res;
    }
}
