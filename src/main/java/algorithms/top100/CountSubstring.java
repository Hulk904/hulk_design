package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/19.
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

 示例 1:

 输入: "abc"
 输出: 3
 解释: 三个回文子串: "a", "b", "c".
 示例 2:

 输入: "aaa"
 输出: 6
 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

 */
public class CountSubstring {

    public static void main(String[] args) {

        System.out.println(countSubstringsDynamic("aaa"));


    }

    //马拉车算法  没有看懂

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int countSubstringsDynamic(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j >= 0; j--){//int j = 0; j <= i; j++
                if (s.charAt(i) == s.charAt(j) && (i -j < 2 || dp[i - 1][j + 1])){//从外往内缩 。而不是 dp[i + 1][j - 1]
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 中心往两边扩展
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int total=0;
        for (int i = 0; i < s.length(); i++){
            total += count(s, i, i);
            total += count(s, i, i + 1);
        }
        return total;
    }

    private static int count(String s, int start, int end){
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--)==s.charAt(end++)){
            count++;
        }
        return count;
    }
}
