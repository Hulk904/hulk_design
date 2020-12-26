package algorithms.other.string;

/**
 * Created by yangyuan on 2020/12/22.
 * 639. 解码方法 2
 *
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。

 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。

 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）

 */
public class NumDecodings {

    public int numDecodings(String s) {
        int n = s.length(), mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= 26; j++){
                char a = s.charAt(i - 1);
                if (j <= 9){
                    if (a == '*' || a == j + '0') dp[i] += dp[i - 1];
                } else if (i >= 2){
                    char b = s.charAt(i - 2);
                    int y = j/ 10 , x = j%10;
                    //j 跟  ab 匹配， 单独匹配就行  ,  a == *  后面为啥还要 x > 0 ？ 因为 *只能 替代 1～9么？
                    if ((b == y + '0' || (b == '*' && y > 0)) && (a == x + '0' || (a == '*' && x > 0))){
                        dp[i] += dp[i - 2];
                    }
                }
                dp[i] = dp[i]%mod;
            }
        }
        return dp[n];
    }
}
