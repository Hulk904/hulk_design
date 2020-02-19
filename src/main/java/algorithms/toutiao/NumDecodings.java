package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/2/9.
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0'){
            return 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i< s.length(); i++){
            if (s.charAt(i) != '0'){
                if (i >= 1 && Integer.parseInt(s.substring(i-1,i + 1)) <= 26){
                    if (i ==1){
                        dp[1] = 2;
                    } else {
                        if (s.charAt(i - 1) == '0'){
                            dp[i] = dp[i - 2];
                        } else {
                            dp[i] = dp[i - 1] + dp[i - 2];
                        }
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (s.charAt(i - 1) == '0'){
                    return 0;
                }
                if (i >= 2) {
                    if (Integer.parseInt(s.substring(i-1,i + 1)) <= 26) {
                        dp[i] = dp[i - 2];
                    } else {
                        return 0;
                    }
                }else {
                    if (s.charAt(0) > '2'){
                        return 0;
                    }
                    dp[i] = 1;
                }
            }

        }
        return dp[s.length() - 1];
    }
}
